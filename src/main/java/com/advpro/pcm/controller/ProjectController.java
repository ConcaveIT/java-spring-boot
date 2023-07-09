package com.advpro.pcm.controller;

import com.advpro.pcm.model.Project;
import com.advpro.pcm.dto.ProjectDto;
import com.advpro.pcm.service.ProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {    

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAll(){
        return ResponseEntity.ok(projectService.getAll());
    }

    @PostMapping
    public ResponseEntity<Project> store(@RequestBody ProjectDto projectDto) {
        return new ResponseEntity<>(projectService.store(projectDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> show(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(projectService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(
    	@PathVariable("id") Integer id, 
    	@RequestBody ProjectDto projectDto
    ) {
        return ResponseEntity.ok(projectService.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable("id") Integer id){
        projectService.destroy(id);

        return new ResponseEntity<String>("The specific record is deleted!", HttpStatus.OK);
    }
    
}