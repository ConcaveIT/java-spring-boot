package com.topic03mohosin.topic03mohosin.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topic03mohosin.topic03mohosin.dto.ProjectCostReportResponse;
import com.topic03mohosin.topic03mohosin.dto.ProjectDto;
import com.topic03mohosin.topic03mohosin.entity.CostItem;
import com.topic03mohosin.topic03mohosin.entity.Project;
import com.topic03mohosin.topic03mohosin.repository.CostCategoryRepository;
import com.topic03mohosin.topic03mohosin.repository.CostItemRepository;
import com.topic03mohosin.topic03mohosin.service.CostCategoryService;
import com.topic03mohosin.topic03mohosin.service.CostItemService;
import com.topic03mohosin.topic03mohosin.service.MemberService;
import com.topic03mohosin.topic03mohosin.service.ProjectService;

@RestController
@RequestMapping("/project-cost-report")
public class ProjectCostReportController {

    
    
    @Autowired
    private CostCategoryService costCategoryService;

    @Autowired
    private CostItemService costItemService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MemberService memberService;


    @Autowired
    CostItemRepository costItemRepository;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ProjectCostReportResponse generateProjectCostReport(
            @RequestParam("projectId") Long projectId,
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        // Fetch the project details based on the projectId
        ProjectDto project = projectService.getProjectById(projectId);

        // Calculate total cost
        double totalCost = calculateTotalCost(projectId, startDate, endDate);

        // Calculate member-wise cost
        Map<String, Double> memberWiseCost = calculateMemberWiseCost(projectId, startDate, endDate);

        // Calculate category-wise cost
        Map<String, Double> categoryWiseCost = calculateCategoryWiseCost(projectId, startDate, endDate);

        // Create the project cost report object
        ProjectCostReportResponse report = new ProjectCostReportResponse();
        report.setTotalCost(totalCost);
        report.setMemberWiseCost(memberWiseCost);
        report.setCategoryWiseCost(categoryWiseCost);

        return report;
    }

  

    private double calculateTotalCost(long projectId, LocalDate startDate, LocalDate endDate) {

        List<CostItem> costItems = costItemRepository.findAllByProjectIdAndDateBetween(projectId, startDate, endDate);

        double totalCost = costItems.stream().mapToDouble(CostItem::getAmount).sum();

        return totalCost;
    }


    
    private Map<String, Double> calculateMemberWiseCost(long projectId, LocalDate startDate, LocalDate endDate) {

        List<CostItem> costItems = costItemRepository.findAllByProjectIdAndDateBetween(projectId, startDate, endDate);
        Map<String, Double> memberWiseCostMap = new HashMap<>();

        for (CostItem costItem : costItems) {
            memberWiseCostMap.put(costItem.getEntryBy().getMemberName(), costItem.getAmount());
        }
        return memberWiseCostMap;
    }
    
    private Map<String, Double> calculateCategoryWiseCost(long projectId, LocalDate startDate, LocalDate endDate) {
        List<CostItem> costItems = costItemRepository.findAllByProjectIdAndDateBetween(projectId, startDate, endDate);
        Map<String, Double> categoryWiseCost = new HashMap<>();

        for (CostItem costItem : costItems) {
            categoryWiseCost.put(costItem.getCostCategory().getCategoryName(), costItem.getAmount());
        }
        return categoryWiseCost;
    }

 
}