package com.advpro.todo.service.impl;

import com.advpro.todo.model.Todo;
import com.advpro.todo.repository.TodoRepository;
import com.advpro.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo storeTodo(Todo todo) {
        todoRepository.save(todo);

        return todo;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        todoRepository.save(todo);

        return todo;
    }

    @Override
    public String deleteTodo(Integer id) {
        todoRepository.deleteById(id);

        return "Deleted Successfully!";
    }

    @Override
    public Todo getTodo(Integer id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    
}
