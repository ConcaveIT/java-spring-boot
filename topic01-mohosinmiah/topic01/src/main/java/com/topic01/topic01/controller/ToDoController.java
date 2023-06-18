package com.topic01.topic01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topic01.topic01.dto.ToDoDto;
import com.topic01.topic01.service.ToDoService;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {
    
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDoDto> getAllToDo(){
        return toDoService.getAllToDo();
    }

    @PostMapping
    public ToDoDto saveTodo(
        @RequestBody ToDoDto toDoRequest
    ){
        return toDoService.saveTodo(toDoRequest);
    }

    @GetMapping("/{toDoId}")
    public ToDoDto getToDoById(@PathVariable("toDoId") Long toDoId){
        return toDoService.getToDoById(toDoId);
    }

    @PutMapping("/{toDoId}")
    public ToDoDto updateToDoById(
        @PathVariable("toDoId") Long toDoId,
        @RequestBody ToDoDto toDoRequest
    ){
        return toDoService.updateToDoById(toDoId, toDoRequest);
    }

    @DeleteMapping("/{toDoId}")
    public String deleteToDoById(@PathVariable("toDoId") Long toDoId){
        return toDoService.deleteToDoById(toDoId);
    }

}
