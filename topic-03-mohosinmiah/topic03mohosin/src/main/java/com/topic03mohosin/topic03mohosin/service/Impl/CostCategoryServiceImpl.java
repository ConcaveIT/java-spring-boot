package com.topic03mohosin.topic03mohosin.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.dto.CostCategoryDto;
import com.topic03mohosin.topic03mohosin.dto.ProjectDto;
import com.topic03mohosin.topic03mohosin.entity.CostCategory;
import com.topic03mohosin.topic03mohosin.entity.Project;
import com.topic03mohosin.topic03mohosin.repository.CostCategoryRepository;
import com.topic03mohosin.topic03mohosin.repository.ProjectRepository;
import com.topic03mohosin.topic03mohosin.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

import com.topic03mohosin.topic03mohosin.service.CostCategoryService;

@Service
public class CostCategoryServiceImpl implements CostCategoryService {

    @Autowired
    private  CostCategoryRepository costCategoryRepository;

    
    @Autowired
    private  ModelMapper modelMapper;


    @Override
    public CostCategoryDto createCostCategory(CostCategoryDto costCategoryDto) {
        CostCategory costCategory = modelMapper.map(costCategoryDto, CostCategory.class);
        CostCategory savedCostCategory = costCategoryRepository.save(costCategory);
        return modelMapper.map(savedCostCategory, CostCategoryDto.class);
    }

    @Override
    public List<CostCategoryDto> getAllCostCategories() {
        List<CostCategory> costCategories = costCategoryRepository.findAll();
        return costCategories.stream()
                .map(costCategory -> modelMapper.map(costCategory, CostCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CostCategoryDto getCostCategoryById(Long id) {
        CostCategory costCategory = costCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cost category not found with id: " + id));
        return modelMapper.map(costCategory, CostCategoryDto.class);
    }

    @Override
    public CostCategoryDto updateCostCategory(Long id, CostCategoryDto costCategoryDto) {
        CostCategory costCategory = costCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cost category not found with id: " + id));

        costCategory.setCategoryName(costCategoryDto.getCategoryName());
        costCategory.setCategoryDescription(costCategoryDto.getCategoryDescription());

        CostCategory updatedCostCategory = costCategoryRepository.save(costCategory);
        return modelMapper.map(updatedCostCategory, CostCategoryDto.class);
    }

    @Override
    public String deleteCostCategory(Long id) {
        costCategoryRepository.deleteById(id);
        return "Cost category deleted";
    }
}
