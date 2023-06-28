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

import com.topic03mohosin.topic03mohosin.dto.CostItemRequest;
import com.topic03mohosin.topic03mohosin.dto.CostItemResponse;
import com.topic03mohosin.topic03mohosin.service.CostItemService;


@RestController
@RequestMapping("/costitems")
public class CostItemController {

    @Autowired
    private CostItemService costItemService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CostItemResponse> createCostItem(@RequestBody CostItemRequest costItemDto) {
        CostItemResponse createdCostItem = costItemService.createCostItem(costItemDto);
        return ResponseEntity.ok(createdCostItem);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CostItemResponse>> getAllCostItems() {
        List<CostItemResponse> costItems = costItemService.getAllCostItems();
        return ResponseEntity.ok(costItems);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CostItemResponse> getCostItemById(@PathVariable Long id) {
        CostItemResponse costItem = costItemService.getCostItemById(id);
        return ResponseEntity.ok(costItem);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CostItemResponse> updateCostItem(@PathVariable Long id, @RequestBody CostItemRequest costItemDto) {
        CostItemResponse updatedCostItem = costItemService.updateCostItem(id, costItemDto);
        return ResponseEntity.ok(updatedCostItem);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCostItem(@PathVariable Long id) {
        return ResponseEntity.ok(costItemService.deleteCostItem(id));
    }
}

