package com.topic03mohosin.topic03mohosin.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.dto.CostItemRequest;
import com.topic03mohosin.topic03mohosin.dto.CostItemResponse;
import com.topic03mohosin.topic03mohosin.entity.CostCategory;
import com.topic03mohosin.topic03mohosin.entity.CostItem;
import com.topic03mohosin.topic03mohosin.entity.Project;
import com.topic03mohosin.topic03mohosin.repository.CostCategoryRepository;
import com.topic03mohosin.topic03mohosin.repository.CostItemRepository;
import com.topic03mohosin.topic03mohosin.repository.ProjectRepository;
import com.topic03mohosin.topic03mohosin.service.CostItemService;
import com.topic03mohosin.topic03mohosin.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CostItemServiceImpl implements CostItemService {

    @Autowired
    private CostItemRepository costItemRepository;

    @Autowired
    private  CostCategoryRepository costCategoryRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CostItemResponse createCostItem(CostItemRequest costItemDto)
    {

        CostItem costItem = new CostItem();
        // Get Cost Category By ID and check category is exist or not
        CostCategory costCategory = costCategoryRepository.findById(costItemDto.getCostCategory()).get();

        // Get Project By ID and check Project is exist or not
        Project project = projectRepository.findById(costItemDto.getProject()).get();
        
        if(costCategory.getId() > 0 && project.getId() > 0 )
        {

        costItem.setItemName(costItemDto.getItemName());
        costItem.setItemDescription(costItemDto.getItemDescription());
        costItem.setAmount(costItemDto.getAmount());

        costItem.setCostCategory(costCategory);



        costItem.setProject(project);

        costItem.setDate(costItemDto.getDate());
        costItem.setEntryBy(costItemDto.getEntryBy());
        costItem.setApprovedBy(costItemDto.getApprovedBy());
        costItem.setStatus(costItemDto.getStatus());

        CostItem saveCostItem = costItemRepository.save(costItem);
        return modelMapper.map(saveCostItem, CostItemResponse.class);
        }
        else
        {
            throw  new EntityNotFoundException("Cost item not save");
        }

    }

    @Override
    public List<CostItemResponse> getAllCostItems()
    {
        List<CostItem> costItems = costItemRepository.findAll();
        return costItems.stream()
                .map(costItem -> modelMapper.map(costItem, CostItemResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CostItemResponse getCostItemById(Long id)
    {
        CostItem costItem = costItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cost item not found with id: " + id));
        return modelMapper.map(costItem, CostItemResponse.class);
    }

    @Override
    public CostItemResponse updateCostItem(Long id, CostItemRequest costItemDto)
    {
        CostItem costItem = costItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cost item not found with id: " + id));

                
        // Get Cost Category By ID and check category is exist or not
        CostCategory costCategory = costCategoryRepository.findById(costItemDto.getCostCategory()).get();

        // Get Project By ID and check Project is exist or not
        Project project = projectRepository.findById(costItemDto.getProject()).get();
        
        if(costCategory.getId() > 0 && project.getId() > 0 )
        {

        costItem.setItemName(costItemDto.getItemName());
        costItem.setItemDescription(costItemDto.getItemDescription());
        costItem.setAmount(costItemDto.getAmount());

        costItem.setCostCategory(costCategory);



        costItem.setProject(project);

        costItem.setDate(costItemDto.getDate());
        costItem.setEntryBy(costItemDto.getEntryBy());
        costItem.setApprovedBy(costItemDto.getApprovedBy());
        costItem.setStatus(costItemDto.getStatus());

        CostItem updatedCostItem = costItemRepository.save(costItem);
        return modelMapper.map(updatedCostItem, CostItemResponse.class);
        }
        else
        {
            throw  new EntityNotFoundException("Cost item not updated ");
        }
       
    }

    @Override
    public String deleteCostItem(Long id)
    {
        Optional<CostItem> getCostItem = costItemRepository.findById(id);

        if(getCostItem.isPresent()) {
            CostItem costItem = getCostItem.get();
            // Delete cost Item
           costItemRepository.deleteById(id);

            return "Project deleted : ID " + costItem.getId();
        }
        else
        {
            return "Project not found with ID: " + id;
        }
    }
}
