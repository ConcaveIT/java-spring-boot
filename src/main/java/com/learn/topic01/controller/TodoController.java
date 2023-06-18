package com.learn.topic01.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.topic01.model.Todo;
import com.learn.topic01.repository.TodoRepository;

@RestController
@RequestMapping("api/v1/todos")

public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping
    public List<Todo> getAllEntities() {
        return todoRepository.findAll();
    }

   @GetMapping("/{todoId}")
    public ResponseEntity<?> findById(@PathVariable("todoId") Long todoId) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);

        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodoById(@PathVariable("todoId") Long todoId) {
        if (todoRepository.existsById(todoId)) {
            todoRepository.deleteById(todoId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{todoId}")
    public Todo updateToDoById(
        @PathVariable("todoId")  Long todoId,
        @RequestBody Todo todo
    ){
        // Get todo by ID
        Todo getToDo = todoRepository.findById(todoId).get();
        // Set new value to ToDo 
        getToDo.setTitle(todo.getTitle()); // Update new title
        getToDo.setDescription(todo.getDescription()); // Update new description
        getToDo.setStatus(todo.getStatus()); // Update new status
        // Save todo based on new updated request
        todoRepository.save(getToDo);

        // Get updated todo from database
        Todo updatedToDo = todoRepository.findById(todoId).get();

        return updatedToDo;

    }


}

