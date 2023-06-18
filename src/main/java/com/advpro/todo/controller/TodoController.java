package com.advpro.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.advpro.todo.model.Todo;
import com.advpro.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {    

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo storeTodo(@RequestBody Todo todo) {
        return todoService.storeTodo(todo);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") Integer id) {
        return todoService.getTodo(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(
    	@PathVariable("id") Integer id, 
    	@RequestBody Todo todo
    ) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable("id") Integer id){
        todoService.deleteTodo(id);

        return "Todo item Deleted Successfully!";
    }
    
}