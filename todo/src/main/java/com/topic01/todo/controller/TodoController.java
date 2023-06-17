package com.topic01.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.topic01.todo.entity.Todo;
import com.topic01.todo.service.TodoServiceImp;

@RestController
@RequestMapping("todos")
public class TodoController {

    @Autowired
    TodoServiceImp todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> findAllTodos() {
        try {
            List<Todo> todos = todoService.findAllTodos();

            if (todos.isEmpty() || todos.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(todos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return new ResponseEntity<Todo>(todoService.saveTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> findTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoService.findTodoById(id);

        if (todo.isPresent()) {
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setID(id);
        return new ResponseEntity<>(todoService.updateTodoById(todo), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("User Successfully deleted!", HttpStatus.OK);
    }
}
