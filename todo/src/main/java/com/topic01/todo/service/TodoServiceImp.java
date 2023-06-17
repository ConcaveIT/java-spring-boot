package com.topic01.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic01.todo.entity.Todo;
import com.topic01.todo.repository.TodoRepository;

@Service
public class TodoServiceImp implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo updateTodoById(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getID()).get();

        existingTodo.setDescription(todo.getDescription());
        existingTodo.setStatus(todo.getStatus());
        existingTodo.setTitle(todo.getTitle());

        return todoRepository.save(existingTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
