package com.todo.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "todo")
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "title", nullable = false)
    @NotEmpty(message = "Title Field is required")
    @Size(min = 3, message = "Title Should have at least 3 character")
    private String title;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "Description Field is required")
    @Size(min = 5, message = "Description Should have at least 5 characters")
    private String description;

    @Column(name = "Status", nullable = false)
    @NotEmpty(message = "Status Field is required")
    private String status;


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
