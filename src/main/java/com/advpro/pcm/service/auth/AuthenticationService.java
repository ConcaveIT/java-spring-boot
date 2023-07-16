package com.advpro.pcm.service.auth;

import com.advpro.pcm.service.auth.JwtService;
import com.advpro.pcm.model.Member;
import com.advpro.pcm.repository.MemberRepository;
import com.advpro.pcm.model.enumtype.Role;
import com.advpro.pcm.model.Token;
import com.advpro.pcm.model.enumtype.TokenType;
import com.advpro.pcm.repository.TokenRepository;

import com.advpro.pcm.dto.MemberDto;
import com.advpro.pcm.dto.validator.DtoValidator;
import com.advpro.pcm.exception.DtoValidationException;
import com.advpro.pcm.dto.auth.AuthRequest;
import com.advpro.pcm.dto.auth.AuthResponse;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final DtoValidator<MemberDto> memberValidator;
    private final DtoValidator<AuthRequest> loginValidator;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(MemberDto request) {
        var validationErrors = memberValidator.validate(request);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        var member = Member.builder()
                           .name(request.getName())
                           .email(request.getEmail())
                           .password(passwordEncoder.encode(request.getPassword()))
                           .role(request.getRole())
                           .department(request.getDepartment())
                           .status(request.getStatus())
                           .createdAt(request.getCreatedAt())
                           .updatedAt(request.getUpdatedAt())
                           .build();

        var savedMember = memberRepository.save(member);
        var jwtToken = jwtService.generateToken(member);
        var refreshToken = jwtService.generateRefreshToken(member);

        saveUserToken(savedMember, jwtToken);

        return AuthResponse.builder()
                           .accessToken(jwtToken)
                           .refreshToken(refreshToken)
                           .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        var validationErrors = loginValidator.validate(request);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        
        var user = memberRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);

        return AuthResponse.builder()
                           .accessToken(jwtToken)
                           .refreshToken(refreshToken)
                           .build();
    }

    private void saveUserToken(Member member, String jwtToken) {
        var token = Token.builder()
                         .member(member)
                         .token(jwtToken)
                         .tokenType(TokenType.BEARER)
                         .expired(false)
                         .revoked(false)
                         .build();

        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Member member) {
        var validMemberTokens = tokenRepository.findAllValidTokenByMember(member.getId());

        if (validMemberTokens.isEmpty()) 
            return;

        validMemberTokens.forEach(token-> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenRepository.saveAll(validMemberTokens);
    }

    public void refreshToken(
        HttpServletRequest request, 
        HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail != null) {
            var user = this.memberRepository.findByEmail(userEmail).orElseThrow();

            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);

                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);

                var authResponse = AuthResponse.builder()
                                               .accessToken(accessToken)
                                               .refreshToken(refreshToken)
                                               .build();

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}