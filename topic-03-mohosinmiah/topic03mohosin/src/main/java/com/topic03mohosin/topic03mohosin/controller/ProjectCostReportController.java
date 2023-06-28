package com.topic03mohosin.topic03mohosin.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topic03mohosin.topic03mohosin.dto.ProjectCostReportResponse;
import com.topic03mohosin.topic03mohosin.dto.ProjectDto;
import com.topic03mohosin.topic03mohosin.entity.Project;
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



    @GetMapping
    public ProjectCostReportResponse generateProjectCostReport(
            @RequestParam("projectId") Long projectId,
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        // Fetch the project details based on the projectId
        ProjectDto project = projectService.getProjectById(projectId);

        // Calculate total cost
        double totalCost = calculateTotalCost(project, startDate, endDate);

        // Calculate member-wise cost
        Map<String, Double> memberWiseCost = calculateMemberWiseCost(project, startDate, endDate);

        // Calculate category-wise cost
        Map<String, Double> categoryWiseCost = calculateCategoryWiseCost(project, startDate, endDate);

        // Create the project cost report object
        ProjectCostReportResponse report = new ProjectCostReportResponse();
        report.setTotalCost(totalCost);
        report.setMemberWiseCost(memberWiseCost);
        report.setCategoryWiseCost(categoryWiseCost);

        return report;
    }

  

    private double calculateTotalCost(ProjectDto project, LocalDate startDate, LocalDate endDate) {
        return 0;
    }


    
    private Map<String, Double> calculateMemberWiseCost(ProjectDto project, LocalDate startDate, LocalDate endDate) {
        return null;
    }
    
    private Map<String, Double> calculateCategoryWiseCost(ProjectDto project, LocalDate startDate, LocalDate endDate) {
        return null;
    }

 
}