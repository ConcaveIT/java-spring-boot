package com.topic01.topic01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topic01.topic01.entity.Todo;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Long>{
    
}
