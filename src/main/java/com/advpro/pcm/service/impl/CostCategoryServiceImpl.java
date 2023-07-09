package com.advpro.pcm.service.impl;

import com.advpro.pcm.model.CostCategory;
import com.advpro.pcm.dto.CostCategoryDto;
import com.advpro.pcm.repository.CostCategoryRepository;
import com.advpro.pcm.service.CostCategoryService;
import com.advpro.pcm.dto.validator.DtoValidator;
import com.advpro.pcm.exception.DtoValidationException;
import com.advpro.pcm.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCategoryServiceImpl implements CostCategoryService {

    CostCategoryRepository costCategoryRepository;
    DtoValidator<CostCategoryDto> costCategoryValidator;

    public CostCategoryServiceImpl(CostCategoryRepository costCategoryRepository, DtoValidator<CostCategoryDto> costCategoryValidator) {
        this.costCategoryRepository = costCategoryRepository;
        this.costCategoryValidator = costCategoryValidator;
    }

    @Override
    public CostCategory store(CostCategoryDto costCategoryDto) {
        var validationErrors = costCategoryValidator.validate(costCategoryDto);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        CostCategory costCategory = CostCategory.build(
            0,
            costCategoryDto.getName(),
            costCategoryDto.getDescription(),
            costCategoryDto.getCreatedAt(),
            costCategoryDto.getUpdatedAt(),
            costCategoryDto.getDeletedAt()
        );

        costCategory = costCategoryRepository.save(costCategory);

        return costCategory;
    }

    @Override
    public CostCategory update(Integer id, CostCategoryDto costCategoryDto) {
        if(costCategoryRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        var validationErrors = costCategoryValidator.validate(costCategoryDto);
        
        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        CostCategory costCategory = costCategoryRepository.findById(id).get();
        costCategory.setName(costCategoryDto.getName());
        costCategory.setDescription(costCategoryDto.getDescription());
        costCategory.setCreatedAt(costCategoryDto.getCreatedAt());
        costCategory.setUpdatedAt(costCategoryDto.getUpdatedAt());
        costCategory.setDeletedAt(costCategoryDto.getDeletedAt());
        costCategoryRepository.save(costCategory);

        return costCategory;
    }

    @Override
    public String destroy(Integer id) {
        costCategoryRepository.deleteById(id);

        return "Deleted Successfully!";
    }

    @Override
    public CostCategory show(Integer id) {
        if(costCategoryRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        return costCategoryRepository.findById(id).get();
    }

    @Override
    public List<CostCategory> getAll() {
        return costCategoryRepository.findAll();
    }
    
}
