package com.example.todo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todo.entity.TodoEntity;
import com.example.todo.repository.TodoRepository;

public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoEntity>> getAllTodoList() {
        try {
            List<TodoEntity> todoList = new ArrayList<>();
            todoRepository.findAll().forEach(todoList::add);

            if (todoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoEntity> getTodoById(@PathVariable Long id) {
        Optional<TodoEntity> TodoObj = todoRepository.findById(id);
        if (TodoObj.isPresent()) {
            return new ResponseEntity<>(TodoObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoEntity> ddTodo(@RequestBody TodoEntity Todo) {
        try {
            TodoEntity TodoObj = todoRepository.save(Todo);
            return new ResponseEntity<>(TodoObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/todos/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable Long id, @RequestBody TodoEntity Todo) {
        try {
            Optional<TodoEntity> TodoData = todoRepository.findById(id);
            if (TodoData.isPresent()) {
                TodoEntity updatedTodoData = TodoData.get();
                updatedTodoData.setTitle(Todo.getTitle());
                // updatedTodoData.setTodoMethod(Todo.getTodoMethod());

                TodoEntity TodoObj = todoRepository.save(updatedTodoData);
                return new ResponseEntity<>(TodoObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable Long id) {
        try {
            todoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
