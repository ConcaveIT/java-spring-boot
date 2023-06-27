package com.topic03mohosin.topic03mohosin.service;

import java.util.List;

import com.topic03mohosin.topic03mohosin.dto.CostItemRequest;
import com.topic03mohosin.topic03mohosin.dto.CostItemResponse;

public interface CostItemService {
    CostItemResponse createCostItem(CostItemRequest costItemDto);
    List<CostItemResponse> getAllCostItems();
    CostItemResponse getCostItemById(Long id);
    CostItemResponse updateCostItem(Long id, CostItemRequest costItemDto);
    String deleteCostItem(Long id);
}
