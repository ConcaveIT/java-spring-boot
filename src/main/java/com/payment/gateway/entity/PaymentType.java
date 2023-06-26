package com.payment.gateway.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment_types")
@Data
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String description;

}
