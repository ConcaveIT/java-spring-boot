package com.hasib.ToDo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class TodoDto {

    private Long id;

    @NotBlank(message = "Title can't be empty")
    private String title;

    @NotEmpty(message = "Description can't be empty")
    private String description;

    @NotEmpty(message = "Status can't be empty")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TodoDto() {
    }

    public TodoDto(Long id, String title,String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public TodoDto(String errorMessage) {
    }



    
}
