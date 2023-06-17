package com.example.todo.Controller;

import com.example.todo.Entity.Todo;
import com.example.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createtodo", method = RequestMethod.POST)
    public String createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @RequestMapping(value = "readtodos", method = RequestMethod.GET)
    public List<Todo> readTodos(){
        return todoService.readTodos();
    }

    @RequestMapping(value = "updatetodo", method = RequestMethod.PUT)
    public String updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.DELETE)
    public String deleteTodo(@RequestBody Todo todo){
        return todoService.deleteTodo(todo);
    }
}