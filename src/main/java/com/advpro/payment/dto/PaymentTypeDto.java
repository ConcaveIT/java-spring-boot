package com.advpro.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PaymentTypeDto {

	@NotBlank(message = "The name field shouldn't be empty!")
	private String name;

	@NotBlank(message = "The description field shouldn't be empty!")
	private String description;

	@NotBlank(message = "The created at field shouldn't be empty!")
	private Date createdAt;

	@NotBlank(message = "The updated at field shouldn't be empty!")
	private Date UpdatedAt;

	private Date DeletedAt;

}