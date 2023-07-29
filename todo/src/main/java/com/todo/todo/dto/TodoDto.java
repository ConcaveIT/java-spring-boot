package com.todo.todo.dto;

import com.todo.todo.model.Todo;

public class TodoDto {
    
    private Long ID;
    private String title;
    private String description;
    private String status;

    public TodoDto(Todo todo)
    {
        this.ID             = todo.getID();
        this.title          = todo.getTitle();
        this.description    = todo.getDescription();
        this.status         = todo.getStatus();
    }


    public Long getID()
    {
        return ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
