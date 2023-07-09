package com.advpro.pcm.service;

import com.advpro.pcm.model.CostCategory;
import com.advpro.pcm.dto.CostCategoryDto;

import java.util.List;

public interface CostCategoryService {

    public CostCategory store(CostCategoryDto costCategoryDto);

    public CostCategory update(Integer id, CostCategoryDto costCategoryDto);

    public String destroy(Integer id);

    public CostCategory show(Integer id);
    
    public List<CostCategory> getAll();

}