package com.topic03mohosin.topic03mohosin.service;

import java.util.List;

import com.topic03mohosin.topic03mohosin.dto.ProjectDto;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectById(Long id);
    ProjectDto updateProject(Long id, ProjectDto projectDto);
    String deleteProject(Long id);
}

