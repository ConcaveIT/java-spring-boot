package com.springboot.todo.controller;

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

import com.springboot.todo.entity.Todo;
import com.springboot.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    
    @GetMapping("/health")
    public String showAppHealth(){
        return "ok !!";
    }

    @Autowired
    TodoRepository todoRepo;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
		try {
			List<Todo> list = todoRepo.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/todos")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
        try {
			return new ResponseEntity<Todo>(todoRepo.save(todo),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @GetMapping("/todos/{id}")
	public ResponseEntity<Todo> geTodo(@PathVariable Long id) {
		try {
			Optional<Todo> todo = todoRepo.findById(id);

            if (todo.isPresent()) {
                return new ResponseEntity<>(todo.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodos(@PathVariable Long id,@RequestBody Todo updaeTodo) {
		try {
			Todo todo = todoRepo.getById(id);

            todo.setTitle(updaeTodo.getTitle());
            todo.setDescription(updaeTodo.getDescription());
            todo.setStatus(updaeTodo.getStatus());
            return new ResponseEntity<Todo>(todoRepo.save(todo),HttpStatus.CREATED);            

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


    @DeleteMapping("/todos/{id}")
	public ResponseEntity<HttpStatus> deleteTodo(@PathVariable Long id) {
		try {
			Optional<Todo> todo = todoRepo.findById(id);
			if (todo.isPresent()) {
				todoRepo.delete(todo.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
            else{
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
