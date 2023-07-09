package com.advpro.pcm.dto;

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
public class CostCategoryDto {

	@NotNull(message = "The name field shouldn't be empty!")
	@Size(min = 2, message = "The name must be at least 2 characters")
	@Size(max = 100, message = "The name must be at most 100 characters")
	private String name;

	@NotNull(message = "The description field shouldn't be empty!")
	@Size(min = 2, message = "The description must be at least 2 characters")
	@Size(max = 2000, message = "The description must be at most 2000 characters")
	private String description;

	@NotNull(message = "The created at field shouldn't be empty!")
	private Date createdAt;

	@NotNull(message = "The updated at field shouldn't be empty!")
	private Date UpdatedAt;

	private Date DeletedAt;

}