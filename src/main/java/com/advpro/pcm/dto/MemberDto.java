package com.advpro.pcm.dto;

import com.advpro.pcm.model.enumtype.Role;
import com.advpro.pcm.model.enumtype.Department;
import com.advpro.pcm.model.enumtype.MemberStatus;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MemberDto {

	@NotNull(message = "The name field shouldn't be empty!")
	@Size(min = 2, message = "{validation.name.size.too_short}")
	@Size(max = 100, message = "{validation.name.size.too_long}")
	private String name;

	@NotNull(message = "The role field shouldn't be empty!")
	private Role role;

	@NotNull(message = "The email field shouldn't be empty!")
	@Size(min = 2, message = "{validation.email.size.too_short}")
	@Size(max = 200, message = "{validation.email.size.too_long}")
	private String email;

	@NotNull(message = "The password field shouldn't be empty!")
	@Size(min = 6, message = "{validation.password.size.too_short}")
	@Size(max = 50, message = "{validation.password.size.too_long}")
	private String password;

	@NotNull(message = "The department field shouldn't be empty!")
	private Department department;

	@NotNull(message = "The status field shouldn't be empty!")
	private MemberStatus status;

	@NotNull(message = "The created at field shouldn't be empty!")
	private Date createdAt;

	@NotNull(message = "The updated at field shouldn't be empty!")
	private Date UpdatedAt;

	private Date DeletedAt;

}