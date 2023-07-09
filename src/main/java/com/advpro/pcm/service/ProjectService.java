package com.advpro.pcm.service;

import com.advpro.pcm.model.Project;
import com.advpro.pcm.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    public Project store(ProjectDto projectDto);

    public Project update(Integer id, ProjectDto projectDto);

    public String destroy(Integer id);

    public Project show(Integer id);
    
    public List<Project> getAll();

}