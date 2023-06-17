package com.topic01.todo.service;

import java.util.List;

import com.topic01.todo.entity.Todo;

public interface TodoService {
  Todo saveTodo(Todo todo);
  List<Todo> fetchAllTodos();
  Todo getTodoById(Long id);
  Todo updateTodoById(Long id, Todo todo);
}
