package com.todo.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todoapplication.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
