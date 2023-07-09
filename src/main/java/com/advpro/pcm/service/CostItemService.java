package com.advpro.pcm.service;

import com.advpro.pcm.model.CostItem;
import com.advpro.pcm.dto.CostItemDto;

import java.util.List;

public interface CostItemService {

    public CostItem store(CostItemDto costItemDto);

    public CostItem update(Integer id, CostItemDto costItemDto);

    public String destroy(Integer id);

    public CostItem show(Integer id);
    
    public List<CostItem> getAll();

}