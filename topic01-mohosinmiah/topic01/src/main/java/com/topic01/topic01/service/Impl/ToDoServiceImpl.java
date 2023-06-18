package com.topic01.topic01.service.Impl;

import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic01.topic01.dto.ToDoDto;
import com.topic01.topic01.entity.Todo;
import com.topic01.topic01.repository.ToDoRepository;
import com.topic01.topic01.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ToDoDto saveTodo(ToDoDto toDoRequest) {

        // Convert ToDoRequest to ToDO Entity
        Todo todo = modelMapper.map(toDoRequest, Todo.class);

        // Save Todo
        Todo saveToDo = toDoRepository.save(todo);

        return modelMapper.map(saveToDo, ToDoDto.class);
    }

    @Override
    public List<ToDoDto> getAllToDo() {
        // Get All Todo
        List<Todo> todos = toDoRepository.findAll();

        // Convert Todo Entity list to ToDoDto List
        List<ToDoDto> toDoDtos = todos
        .stream()
        .map(todo -> modelMapper.map(todo, ToDoDto.class))
        .collect(Collectors.toList());
        
        return toDoDtos;

    }

    @Override
    public ToDoDto getToDoById(Long toDoId) {
        // Get ToDo By ID
        Todo todo = toDoRepository.findById(toDoId).get();
        
        // Convert ToDo Entity to ToDoDto 
        ToDoDto toDoDto = modelMapper.map(todo, ToDoDto.class );

        return toDoDto;
        
    }

    @Override
    public ToDoDto updateToDoById(Long toDoId, ToDoDto toDoRequest) {

        // Get ToDo By ID
        Todo todo = toDoRepository.findById(toDoId).get();
        
        // Update Todo
        todo.setName(toDoRequest.getName());
        todo.setDescription(toDoRequest.getDescription());
        todo.setStatus(toDoRequest.getStatus());
        toDoRepository.save(todo);

        // Get Updated Todo
        Todo updateToDo = toDoRepository.findById(toDoId).get();

        // Convert category entity to map category
        ToDoDto todoResponse = modelMapper.map(updateToDo, ToDoDto.class);
        return todoResponse;

    }

    @Override
    public String deleteToDoById(Long toDoId) {
        // Delete ToDo By ID
        toDoRepository.deleteById(toDoId);
        return "ToDo Deleted";
    }

   
    
}
