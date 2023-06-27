package com.topic03mohosin.topic03mohosin.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostItemRequest {
    private String itemName;
    private String itemDescription;
    private double amount;
    private Long costCategory;
    private Long project;
    private LocalDate date;
    private String entryBy;
    private String approvedBy;
    private String status;
}

