package com.todo.todoapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoapplication.entity.Todo;
import com.todo.todoapplication.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("todos")
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long todoId) {
        Todo getTodo = todoService.getTodoById(todoId);
        return new ResponseEntity<>(getTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodo() {
        List<Todo> todolist = todoService.getAllTodo();
        return new ResponseEntity<List<Todo>>(todolist, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long todoId, @RequestBody Todo todo) {
        todo.setId(todoId);
        Todo updateTodo = todoService.updateUser(todo);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>("User Successfully deleted!", HttpStatus.OK);
    }

}
