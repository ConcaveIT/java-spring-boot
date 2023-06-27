package com.topic03mohosin.topic03mohosin.service;

import java.util.List;

import com.topic03mohosin.topic03mohosin.dto.CostCategoryDto;

public interface CostCategoryService {
    CostCategoryDto createCostCategory(CostCategoryDto costCategoryDto);
    List<CostCategoryDto> getAllCostCategories();
    CostCategoryDto getCostCategoryById(Long id);
    CostCategoryDto updateCostCategory(Long id, CostCategoryDto costCategoryDto);
    String deleteCostCategory(Long id);
}

