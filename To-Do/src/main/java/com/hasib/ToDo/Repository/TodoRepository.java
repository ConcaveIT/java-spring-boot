package com.hasib.ToDo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasib.ToDo.Entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
