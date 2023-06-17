package com.topic01.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic01.todo.entity.Todo;
import com.topic01.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
  @Autowired
  private TodoRepository todoRepository;

  @Override
  public Todo saveTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public List<Todo> fetchAllTodos() {
    List<Todo> allTodos = todoRepository.findAll();
    return allTodos;
  }

}
