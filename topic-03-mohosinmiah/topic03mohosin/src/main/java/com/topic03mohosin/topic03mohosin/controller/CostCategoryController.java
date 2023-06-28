package com.topic03mohosin.topic03mohosin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topic03mohosin.topic03mohosin.dto.CostCategoryDto;
import com.topic03mohosin.topic03mohosin.service.CostCategoryService;


@RestController
@RequestMapping("/costcategories")
public class CostCategoryController {

    @Autowired
    private CostCategoryService costCategoryService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CostCategoryDto> createCostCategory(@RequestBody CostCategoryDto costCategoryDto) {
        CostCategoryDto createdCostCategory = costCategoryService.createCostCategory(costCategoryDto);
        return ResponseEntity.ok(createdCostCategory);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CostCategoryDto>> getAllCostCategories() {
        List<CostCategoryDto> costCategories = costCategoryService.getAllCostCategories();
        return ResponseEntity.ok(costCategories);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CostCategoryDto> getCostCategoryById(@PathVariable Long id) {
        CostCategoryDto costCategory = costCategoryService.getCostCategoryById(id);
        return ResponseEntity.ok(costCategory);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CostCategoryDto> updateCostCategory(@PathVariable Long id, @RequestBody CostCategoryDto costCategoryDto) {
        CostCategoryDto updatedCostCategory = costCategoryService.updateCostCategory(id, costCategoryDto);
        return ResponseEntity.ok(updatedCostCategory);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCostCategory(@PathVariable Long id) {
        return ResponseEntity.ok(costCategoryService.deleteCostCategory(id));
    }
}
