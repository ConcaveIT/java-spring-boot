package com.todo.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.todo.dto.TodoDto;
import com.todo.todo.model.Todo;

@Service
public interface TodoService {
    
    public Todo saveTodo(Todo todo);
    public List<TodoDto> getAllTodos();
    public Todo updateTodo(Long Id, Todo todo);
    public Todo deleteTodo(Long Id);
    public Todo getSingleTodo(Long Id);
}

