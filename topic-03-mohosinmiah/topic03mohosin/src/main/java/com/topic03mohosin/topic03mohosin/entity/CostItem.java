package com.topic03mohosin.topic03mohosin.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cost_items")
@Data
public class CostItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemDescription;
    private double amount;

    @OneToOne
    @JoinColumn(
        name = "cost_category_id"
    )
    private CostCategory costCategory;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDate date;

    @OneToOne
    @JoinColumn(
        name = "entryBy"
    )
    private User entryBy;

    @OneToOne
    @JoinColumn(
        name = "approvedBy"
    )
    private User approvedBy;

    private String status;
  
}
