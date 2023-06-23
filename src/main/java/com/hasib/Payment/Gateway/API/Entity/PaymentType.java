package com.hasib.Payment.Gateway.API.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment_type")
@Data
public class PaymentType {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public PaymentType() {
    }

    public PaymentType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PaymentType(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
