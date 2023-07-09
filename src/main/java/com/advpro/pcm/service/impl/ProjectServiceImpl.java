package com.advpro.pcm.service.impl;

import com.advpro.pcm.model.Project;
import com.advpro.pcm.dto.ProjectDto;
import com.advpro.pcm.repository.ProjectRepository;
import com.advpro.pcm.service.ProjectService;
import com.advpro.pcm.dto.validator.DtoValidator;
import com.advpro.pcm.exception.DtoValidationException;
import com.advpro.pcm.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    DtoValidator<ProjectDto> projectValidator;

    public ProjectServiceImpl(ProjectRepository projectRepository, DtoValidator<ProjectDto> projectValidator) {
        this.projectRepository = projectRepository;
        this.projectValidator = projectValidator;
    }

    @Override
    public Project store(ProjectDto projectDto) {
        var validationErrors = projectValidator.validate(projectDto);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        Project project = Project.build(
            0,
            projectDto.getName(),
            projectDto.getDescription(),
            projectDto.getStatus(),
            projectDto.getStartDate(),
            projectDto.getEndDate(),
            projectDto.getCreatedAt(),
            projectDto.getUpdatedAt(),
            projectDto.getDeletedAt()
        );

        project = projectRepository.save(project);

        return project;
    }

    @Override
    public Project update(Integer id, ProjectDto projectDto) {
        if(projectRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        var validationErrors = projectValidator.validate(projectDto);
        
        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        Project project = projectRepository.findById(id).get();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setStatus(projectDto.getStatus());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setCreatedAt(projectDto.getCreatedAt());
        project.setUpdatedAt(projectDto.getUpdatedAt());
        project.setDeletedAt(projectDto.getDeletedAt());
        projectRepository.save(project);

        return project;
    }

    @Override
    public String destroy(Integer id) {
        projectRepository.deleteById(id);

        return "Deleted Successfully!";
    }

    @Override
    public Project show(Integer id) {
        if(projectRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }
    
}
