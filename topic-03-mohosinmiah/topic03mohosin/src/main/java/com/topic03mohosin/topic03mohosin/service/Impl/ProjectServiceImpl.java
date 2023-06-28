package com.topic03mohosin.topic03mohosin.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.dto.ProjectDto;
import com.topic03mohosin.topic03mohosin.entity.Project;
import com.topic03mohosin.topic03mohosin.entity.User;
import com.topic03mohosin.topic03mohosin.repository.ProjectRepository;
import com.topic03mohosin.topic03mohosin.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDto createProject(ProjectDto projectDto)
    {

        Project project = new Project();

        project.setProjectName(projectDto.getProjectName());
        project.setProjectDescription(projectDto.getProjectDescription());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setStatus(projectDto.getStatus());
        Project saveProject = projectRepository.save(project);

        // Convert Project entity to ProjectDto
        return modelMapper.map(saveProject, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAllProjects()
    {

        List<Project> projects =  projectRepository.findAll();

        List<ProjectDto> projectDtos = projects.stream()
                .map(project -> modelMapper.map(project, ProjectDto.class))
                .collect(Collectors.toList());

        return projectDtos;
    }


    @Override
    public ProjectDto getProjectById(Long id)
    {

        Optional<Project> getProject = projectRepository.findById(id);
        if( getProject.isPresent() )
        {
            Project project = getProject.get();
            return modelMapper.map(project, ProjectDto.class);
        }
        else
        {
           throw new EntityNotFoundException("Project not found with id: " + id); 
        }
        
    }


    @Override
    public ProjectDto updateProject(Long id, ProjectDto projectDto)
    {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
    
        project.setProjectName(projectDto.getProjectName());
        project.setProjectDescription(projectDto.getProjectDescription());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setStatus(projectDto.getStatus());
        Project updateProject = projectRepository.save(project);
    
        return modelMapper.map(updateProject, ProjectDto.class);
    }

    @Override
    public String deleteProject(Long id)
    {

        Optional<Project> getProject = projectRepository.findById(id);

        if(getProject.isPresent()) {
            Project project = getProject.get();
            // Delete project
           projectRepository.deleteById(id);

            return "Project deleted : ID " + project.getId();
        }
        else
        {
            return "Project not found with ID: " + id;
        }

    }

}
