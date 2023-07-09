package com.advpro.pcm.dto;

import com.advpro.pcm.model.enumtype.CostItemStatus;

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
public class CostItemDto {

	@NotNull(message = "The name field shouldn't be empty!")
	@Size(min = 2, message = "{validation.name.size.too_short}")
	@Size(max = 100, message = "{validation.name.size.too_long}")
	private String name;

	@NotNull(message = "The description field shouldn't be empty!")
	@Size(min = 2, message = "{validation.description.size.too_short}")
	@Size(max = 2000, message = "{validation.description.size.too_long}")
	private String description;

	@NotNull(message = "The amount field shouldn't be empty!")
	private Float amount;

	@NotNull(message = "The cost category field shouldn't be empty!")
	private Integer costCategoryId;

	@NotNull(message = "The project field shouldn't be empty!")
	private Integer projectId;

	@NotNull(message = "The enter By field shouldn't be empty!")
	private Integer entryBy;

	@NotNull(message = "The approved By field shouldn't be empty!")
	private Integer approvedBy;

	@NotNull(message = "The status field shouldn't be empty!")
	private CostItemStatus status;

	@NotNull(message = "The created at field shouldn't be empty!")
	private Date createdAt;

	@NotNull(message = "The updated at field shouldn't be empty!")
	private Date UpdatedAt;

	private Date DeletedAt;

}