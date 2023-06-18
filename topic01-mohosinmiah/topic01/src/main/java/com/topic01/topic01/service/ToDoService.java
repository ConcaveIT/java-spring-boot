package com.topic01.topic01.service;

import java.util.List;

import com.topic01.topic01.dto.ToDoDto;
import com.topic01.topic01.dto.ToDoDto;

public interface ToDoService {

    ToDoDto saveTodo(ToDoDto toDoRequest);

    List<ToDoDto> getAllToDo();

    ToDoDto getToDoById(Long toDoId);

    ToDoDto updateToDoById(Long toDoId, ToDoDto toDoRequest);

    String deleteToDoById(Long toDoId);

    
}
