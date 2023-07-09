package com.advpro.pcm.dto;

import com.advpro.pcm.model.enumtype.ProjectStatus;

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
public class ProjectDto {

	@NotNull(message = "The name field shouldn't be empty!")
	@Size(min = 2, message = "The name must be at least 2 characters")
	@Size(max = 200, message = "The name must be at most 200 characters")
	private String name;

	@NotNull(message = "The description field shouldn't be empty!")
	@Size(min = 2, message = "The description must be at least 2 characters")
	@Size(max = 2000, message = "The description must be at most 2000 characters")
	private String description;

	@NotNull(message = "The status field shouldn't be empty!")
	private ProjectStatus status;

	@NotNull(message = "The start date field shouldn't be empty!")
	private Date startDate;

	@NotNull(message = "The end date field shouldn't be empty!")
	private Date endDate;

	@NotNull(message = "The created at field shouldn't be empty!")
	private Date createdAt;

	@NotNull(message = "The updated at field shouldn't be empty!")
	private Date UpdatedAt;

	private Date DeletedAt;

}