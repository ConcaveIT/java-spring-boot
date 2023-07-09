package com.advpro.pcm.service.impl;

import com.advpro.pcm.model.CostItem;
import com.advpro.pcm.dto.CostItemDto;
import com.advpro.pcm.repository.CostItemRepository;
import com.advpro.pcm.service.CostItemService;
import com.advpro.pcm.dto.validator.DtoValidator;
import com.advpro.pcm.exception.DtoValidationException;
import com.advpro.pcm.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostItemServiceImpl implements CostItemService {

    CostItemRepository costItemRepository;
    DtoValidator<CostItemDto> costItemValidator;

    public CostItemServiceImpl(CostItemRepository costItemRepository, DtoValidator<CostItemDto> costItemValidator) {
        this.costItemRepository = costItemRepository;
        this.costItemValidator = costItemValidator;
    }

    @Override
    public CostItem store(CostItemDto costItemDto) {
        var validationErrors = costItemValidator.validate(costItemDto);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        CostItem costItem = CostItem.build(
            0,
            costItemDto.getName(),
            costItemDto.getDescription(),
            costItemDto.getAmount(),
            costItemDto.getCostCategoryId(),
            costItemDto.getProjectId(),
            costItemDto.getEntryBy(),
            costItemDto.getApprovedBy(),
            costItemDto.getStatus(),
            costItemDto.getCreatedAt(),
            costItemDto.getUpdatedAt(),
            costItemDto.getDeletedAt()
        );

        costItem = costItemRepository.save(costItem);

        return costItem;
    }

    @Override
    public CostItem update(Integer id, CostItemDto costItemDto) {
        if(costItemRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        var validationErrors = costItemValidator.validate(costItemDto);
        
        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        CostItem costItem = costItemRepository.findById(id).get();
        costItem.setName(costItemDto.getName());
        costItem.setDescription(costItemDto.getDescription());
        costItem.setAmount(costItemDto.getAmount());
        costItem.setCostCategoryId(costItemDto.getCostCategoryId());
        costItem.setProjectId(costItemDto.getProjectId());
        costItem.setEntryBy(costItemDto.getEntryBy());
        costItem.setApprovedBy(costItemDto.getApprovedBy());
        costItem.setStatus(costItemDto.getStatus());
        costItem.setCreatedAt(costItemDto.getCreatedAt());
        costItem.setUpdatedAt(costItemDto.getUpdatedAt());
        costItem.setDeletedAt(costItemDto.getDeletedAt());
        costItemRepository.save(costItem);

        return costItem;
    }

    @Override
    public String destroy(Integer id) {
        costItemRepository.deleteById(id);

        return "Deleted Successfully!";
    }

    @Override
    public CostItem show(Integer id) {
        if(costItemRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        return costItemRepository.findById(id).get();
    }

    @Override
    public List<CostItem> getAll() {
        return costItemRepository.findAll();
    }
    
}
