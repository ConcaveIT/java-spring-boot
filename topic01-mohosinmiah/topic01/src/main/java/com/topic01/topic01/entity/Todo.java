package com.topic01.topic01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long id;

    private String name;

    private String description;

    private Boolean status;
}
