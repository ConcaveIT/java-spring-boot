package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
    
}
