package com.advpro.todo.service;

import com.advpro.todo.model.Todo;

import java.util.List;

public interface TodoService {

    public Todo storeTodo(Todo Todo);

    public Todo updateTodo(Todo Todo);

    public String deleteTodo(Integer id);

    public Todo getTodo(Integer id);
    
    public List<Todo> getAllTodos();

}
