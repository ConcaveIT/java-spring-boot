package com.topic01.topic01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {
    
    private Long id;
    
    private String name;

    private String description;

    private Boolean status;
}

