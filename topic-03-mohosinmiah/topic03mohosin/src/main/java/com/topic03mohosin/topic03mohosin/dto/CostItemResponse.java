package com.topic03mohosin.topic03mohosin.dto;


import java.time.LocalDate;

import com.topic03mohosin.topic03mohosin.entity.CostCategory;
import com.topic03mohosin.topic03mohosin.entity.Project;
import com.topic03mohosin.topic03mohosin.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CostItemResponse {
    private String itemName;
    private String itemDescription;
    private double amount;
    private CostCategory costCategory;
    private Project project;
    private LocalDate date;
    private User entryBy;
    private User approvedBy;
    private String status;
}