package com.sftest.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sftest.main.entity.Todo;
import com.sftest.main.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
    private TodoService todoService;
	
	@RequestMapping(value="info",method=RequestMethod.GET)
	public String info() {
		return "the applictaion ins up----";
	}
	
	@RequestMapping(value = "createTodo", method = RequestMethod.POST)
    public String createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }
	
	@RequestMapping(value = "readTodo", method = RequestMethod.GET)
    public List<Todo> readTodo(){
        return todoService.readTodo();
    }
	
	@RequestMapping(value = "updateTodo", method = RequestMethod.PUT)
    public String updateStudet(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }
	
	@RequestMapping(value = "deleteTodo", method = RequestMethod.DELETE)
    public String deleteTodo(@RequestBody Todo todo){
        return todoService.deleteTodo(todo);
    }
	
}
