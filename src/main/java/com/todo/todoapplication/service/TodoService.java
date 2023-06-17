package com.todo.todoapplication.service;

import java.util.List;

import com.todo.todoapplication.entity.Todo;

public interface TodoService {

    Todo createTodo(Todo todo);

    Todo getTodoById(Long todoId);

    List<Todo> getAllTodo();

    Todo updateUser(Todo todo);

    void deleteTodo(Long todoId);
    
}
