package com.topic03mohosin.topic03mohosin.entity;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(
        name = "cost_category_id"
    )
    private CostCategory costCategory;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDate date;
    private String entryBy;
    private String approvedBy;
    private String status;
  
}
