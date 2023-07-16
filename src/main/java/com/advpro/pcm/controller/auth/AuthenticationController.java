package com.advpro.pcm.controller.auth;

import com.advpro.pcm.dto.MemberDto;
import com.advpro.pcm.dto.auth.AuthRequest;
import com.advpro.pcm.dto.auth.AuthResponse;
import com.advpro.pcm.service.auth.AuthenticationService;
import com.advpro.pcm.service.auth.LogoutService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;
    private final LogoutService logoutService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
        @RequestBody MemberDto memberDto
    ) {
        return ResponseEntity.ok(authService.register(memberDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
        @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication
    ) {
        logoutService.logout(request, response, authentication);

        return new ResponseEntity<String>("Logout Successfully!", HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {
        authService.refreshToken(request, response);
    }

}