package com.topic03mohosin.topic03mohosin.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.dto.LoginDTO;
import com.topic03mohosin.topic03mohosin.dto.MemberDto;
import com.topic03mohosin.topic03mohosin.entity.Role;
import com.topic03mohosin.topic03mohosin.entity.User;
import com.topic03mohosin.topic03mohosin.exception.APIException;
import com.topic03mohosin.topic03mohosin.repository.RoleRepository;
import com.topic03mohosin.topic03mohosin.repository.UserRepository;
import com.topic03mohosin.topic03mohosin.security.JwtTokenProvider;
import com.topic03mohosin.topic03mohosin.service.AuthService;



@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        System.out.println("***********************");
        System.out.println(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
    
}