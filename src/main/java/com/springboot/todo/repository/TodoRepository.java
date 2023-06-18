package com.springboot.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
