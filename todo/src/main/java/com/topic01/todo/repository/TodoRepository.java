package com.topic01.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topic01.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
