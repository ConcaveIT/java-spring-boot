package com.advpro.pcm.dto.auth;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

	@NotNull(message = "The email field shouldn't be empty!")
	@Size(min = 2, message = "The email must be at least 2 characters")
	@Size(max = 200, message = "The email must be at most 200 characters")
	private String email;

	@NotNull(message = "The password field shouldn't be empty!")
	@Size(min = 6, message = "The password must be at least 6 characters")
	@Size(max = 50, message = "The password must be at most 50 characters")
	private String password;

}