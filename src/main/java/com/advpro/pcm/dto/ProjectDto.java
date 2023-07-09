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
	@Size(min = 2, message = "{validation.name.size.too_short}")
	@Size(max = 200, message = "{validation.name.size.too_long}")
	private String name;

	@NotNull(message = "The description field shouldn't be empty!")
	@Size(min = 2, message = "{validation.description.size.too_short}")
	@Size(max = 2000, message = "{validation.description.size.too_long}")
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