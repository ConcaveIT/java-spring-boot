package com.advpro.pcm.controller;

import com.advpro.pcm.model.CostCategory;
import com.advpro.pcm.dto.CostCategoryDto;
import com.advpro.pcm.service.CostCategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/costcategories")
public class CostCategoryController {    

    @Autowired
    private CostCategoryService costCategoryService;

    @GetMapping
    public ResponseEntity<List<CostCategory>> getAll(){
        return ResponseEntity.ok(costCategoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<CostCategory> store(@RequestBody CostCategoryDto costCategoryDto) {
        return new ResponseEntity<>(costCategoryService.store(costCategoryDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCategory> show(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(costCategoryService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCategory> update(
    	@PathVariable("id") Integer id, 
    	@RequestBody CostCategoryDto costCategoryDto
    ) {
        return ResponseEntity.ok(costCategoryService.update(id, costCategoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable("id") Integer id){
        costCategoryService.destroy(id);

        return new ResponseEntity<String>("The specific record is deleted!", HttpStatus.OK);
    }
    
}