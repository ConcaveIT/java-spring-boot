package com.faruk.paymenttype.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.faruk.paymenttype.dto.AuthenticationResponse;
import com.faruk.paymenttype.dto.RegisterResponse;
import com.faruk.paymenttype.entity.AuthenticationRequest;
import com.faruk.paymenttype.entity.RegisterRequest;
import com.faruk.paymenttype.entity.Role;
import com.faruk.paymenttype.entity.User;
import com.faruk.paymenttype.repository.UserRepository;
import com.faruk.paymenttype.security.JwtHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

     
    public RegisterResponse register(RegisterRequest request) {
        
    var user = User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
        userRepository.save(user);
      
    // var jwtToken = jwtHelper.generateToken(user);

    return RegisterResponse.builder()
        .username(request.getName())
        .msg("User Registration Successfully")
        .build();
  }

   public AuthenticationResponse authenticate(AuthenticationRequest request) {
   
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    
    var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtHelper.generateToken(user);
  
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
    
}

