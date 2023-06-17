package com.topic01.todo.service;

import java.util.List;
import java.util.Optional;

import com.topic01.todo.entity.Todo;

public interface TodoService {

    public Todo saveTodo(Todo todo);

    public List<Todo> findAllTodos();

    public Optional<Todo> findTodoById(Long id);

    public Todo updateTodoById(Todo todo);

    void deleteTodo(Long id);
}
