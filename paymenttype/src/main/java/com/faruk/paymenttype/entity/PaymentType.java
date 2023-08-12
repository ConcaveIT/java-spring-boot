package com.faruk.paymenttype.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity

public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Name Field is required")
    @Size(min = 4, message = "Name Should have at least 4 character")
    private String name;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "Description Field is required")
    @Size(min = 2, message = "Description Should have at least 2 characters")
    private String description;

 

    public Long getID()
    {
        return ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

   
    
}
