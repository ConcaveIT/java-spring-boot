package com.topic01.todo.service;

import java.util.List;
import java.util.Optional;

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

  @Override
  public Todo getTodoById(Long id) {
    Optional<Todo> todo = todoRepository.findById(id);
    return todo.isPresent() ? todo.get() : null;
  }

  @Override
  public Todo updateTodoById(Long id, Todo todo) {
    Optional<Todo> oldTodo = todoRepository.findById(id);
    if (oldTodo.isPresent()) {
      Todo newTodo = oldTodo.get();
      newTodo.setTitle(todo.getTitle());
      newTodo.setDescription(todo.getDescription());
      newTodo.setStatus(todo.getStatus());
      return todoRepository.save(newTodo);
    }
    return null;
  }

  @Override
  public Todo deleteTodoById(Long id) {
    Optional<Todo> todo = todoRepository.findById(id);
    if(todo.isPresent()) {
      todoRepository.deleteById(id);
      return todo.get();
    }
    return null;
  }

}
