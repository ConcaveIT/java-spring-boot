package com.hasib.Payment.Gateway.API.Dto;

import org.hibernate.validator.constraints.UniqueElements;


import jakarta.validation.constraints.NotBlank;


public class PaymentTypeRequestDto {
    public Long id;

    @UniqueElements(message = "Name is already exist")
    @NotBlank(message = "Name is mandatory")
    public String name;

    @NotBlank(message = "Description is mandatory")
    public String description;

    public PaymentTypeRequestDto() {
    }

    public PaymentTypeRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PaymentTypeRequestDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public PaymentTypeRequestDto(String errorMessage) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
