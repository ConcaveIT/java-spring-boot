package com.todo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.todo.todo.dto.TodoCreateUpdateResponseDto;
import com.todo.todo.dto.TodoCustomResponseDto;
import com.todo.todo.dto.TodoDto;
import com.todo.todo.model.Todo;
import com.todo.todo.service.TodoService;

// import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")

public class TodoController {

    private final  TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}


    @GetMapping(value="/todos")
	public ResponseEntity<?> getAllTodos(){
		List<TodoDto> todos = todoService.getAllTodos();
        if(todos.size() > 0){
            return  ResponseEntity.ok().body(todos);
        }else{
            TodoCustomResponseDto  todoCustomResponseDto;
            todoCustomResponseDto = new TodoCustomResponseDto(false, "Data Not Found");
			
            return ResponseEntity.badRequest().body(todoCustomResponseDto);
        }
	}



    @PostMapping(value="/todos")
    public ResponseEntity<?> saveTodo( @Validated @RequestBody Todo todo)
    {
        TodoCreateUpdateResponseDto  todoCreateUpdateResponseDto;

        try {
			Todo insertTodo =  todoService.saveTodo(todo);
			if (insertTodo != null) {
                todoCreateUpdateResponseDto = new TodoCreateUpdateResponseDto(insertTodo,true, "Data Inserted Successfully");
               
                return ResponseEntity.badRequest().body(todoCreateUpdateResponseDto);
			}

			todoCreateUpdateResponseDto = new TodoCreateUpdateResponseDto(null,false, "Something wrong ! Please insert all input field");
            
            return ResponseEntity.badRequest().body(todoCreateUpdateResponseDto);

		}catch(Exception e) {

			todoCreateUpdateResponseDto = new TodoCreateUpdateResponseDto(null,false, "Something wrong ! Please insert all input field");
			
            return ResponseEntity.badRequest().body(todoCreateUpdateResponseDto);
		}
    }



    @GetMapping(value = "/todos/{Id}")
    @JsonIgnore
    public ResponseEntity<?> getSingleTodo(@PathVariable("Id") Long Id)
    {
        TodoCustomResponseDto  todoCustomResponseDto;
        try {
			Todo todo =  todoService.getSingleTodo(Id);
			if (todo != null) {

                return  ResponseEntity.ok().body(todo);
			}

			todoCustomResponseDto = new TodoCustomResponseDto(false, "Data Not Found");
            
            return ResponseEntity.badRequest().body(todoCustomResponseDto);

		}catch(Exception e) {

			todoCustomResponseDto = new TodoCustomResponseDto(false, "Data Not Found");
			
            return ResponseEntity.badRequest().body(todoCustomResponseDto);
		}
       
    }
    


   @PutMapping(value = "/todos/{Id}")
    public ResponseEntity<?> updateTodo(@Validated @RequestBody Todo todo, @PathVariable("Id") Long Id)
	{
        TodoCreateUpdateResponseDto  todoCreateUpdateResponseDto;

        try {
			Todo updateTodo = todoService.updateTodo(Id,todo);
			if (updateTodo != null) {
                todoCreateUpdateResponseDto = new TodoCreateUpdateResponseDto(updateTodo,true, "Data Updated Successfully");
               
                return ResponseEntity.badRequest().body(todoCreateUpdateResponseDto);
			}

			todoCreateUpdateResponseDto = new TodoCreateUpdateResponseDto(null,false, "Something wrong ! Please check all input field");
            
            return ResponseEntity.badRequest().body(todoCreateUpdateResponseDto);

		}catch(Exception e) {

			todoCreateUpdateResponseDto = new TodoCreateUpdateResponseDto(null,false, "Something wrong ! Please check all input field");
			
            return ResponseEntity.badRequest().body(todoCreateUpdateResponseDto);
		}
        
    }


    @DeleteMapping(value="/todos/{Id}")
	@JsonIgnore
	public ResponseEntity<?> todoDelete(@PathVariable("Id") Long Id)
	{
		TodoCustomResponseDto  todoCustomResponseDto;
		try {
			Todo deleteTodo = todoService.deleteTodo(Id);
			if (deleteTodo != null) {
				todoCustomResponseDto = new TodoCustomResponseDto( true, "Data Deleted Successfully");
				
                return ResponseEntity.ok().body(todoCustomResponseDto);
			}

			todoCustomResponseDto = new TodoCustomResponseDto(false, "Data Not Found");
           
            return ResponseEntity.badRequest().body(todoCustomResponseDto);

		}catch(Exception e) {

			todoCustomResponseDto = new TodoCustomResponseDto(false, "Failed to Deleted Data");

			return ResponseEntity.badRequest().body(todoCustomResponseDto);
		}
	}

   

   
    
}
