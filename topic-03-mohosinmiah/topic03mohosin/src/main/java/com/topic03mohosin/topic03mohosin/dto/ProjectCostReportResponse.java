package com.topic03mohosin.topic03mohosin.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCostReportResponse {
    private double totalCost;
    private Map<String, Double> memberWiseCost;
    private Map<String, Double> categoryWiseCost;
}
