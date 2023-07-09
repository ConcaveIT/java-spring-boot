package com.advpro.pcm.controller;

import com.advpro.pcm.model.CostItem;
import com.advpro.pcm.dto.CostItemDto;
import com.advpro.pcm.service.CostItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/costitems")
public class CostItemController {    

    @Autowired
    private CostItemService costItemService;

    @GetMapping
    public ResponseEntity<List<CostItem>> getAll(){
        return ResponseEntity.ok(costItemService.getAll());
    }

    @PostMapping
    public ResponseEntity<CostItem> store(@RequestBody CostItemDto costItemDto) {
        return new ResponseEntity<>(costItemService.store(costItemDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostItem> show(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(costItemService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostItem> update(
    	@PathVariable("id") Integer id, 
    	@RequestBody CostItemDto costItemDto
    ) {
        return ResponseEntity.ok(costItemService.update(id, costItemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable("id") Integer id){
        costItemService.destroy(id);

        return new ResponseEntity<String>("The specific record is deleted!", HttpStatus.OK);
    }
    
}