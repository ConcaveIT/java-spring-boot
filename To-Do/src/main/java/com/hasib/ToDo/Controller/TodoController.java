package com.hasib.ToDo.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hasib.ToDo.Dto.TodoDto;
import com.hasib.ToDo.Service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTodo(@Valid @RequestBody TodoDto todoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", errorMessage));
        } else {
            TodoDto createTodo = todoService.createTodo(todoDto);
            return ResponseEntity.ok(createTodo);
        }
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoDto>> getAllTodoList(){
        List<TodoDto> todo = todoService.getAllTodoList();
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id){
        TodoDto todo = todoService.getTodoById(id);
        if(todo != null){
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto){
        TodoDto updateTodo = todoService.updateTodo(id, todoDto);
        if(updateTodo != null){
            return ResponseEntity.ok(updateTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        boolean deleted = todoService.deleteTodo(id);
        if(deleted) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
