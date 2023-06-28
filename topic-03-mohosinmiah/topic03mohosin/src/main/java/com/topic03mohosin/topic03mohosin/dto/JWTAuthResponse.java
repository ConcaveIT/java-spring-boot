package com.topic03mohosin.topic03mohosin.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
    
    private String accessToken;
    private String tokenType = "Bearer";
    
}
