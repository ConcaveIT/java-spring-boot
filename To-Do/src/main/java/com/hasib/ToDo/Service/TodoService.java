package com.hasib.ToDo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hasib.ToDo.Dto.TodoDto;
import com.hasib.ToDo.Entity.Todo;
import com.hasib.ToDo.Repository.TodoRepository;

@Service
public class TodoService {
    public TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private Todo convertToEntity(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setStatus(todoDto.getStatus());
        return todo;
    }

    private TodoDto convertToDto(Todo todo) {
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setStatus(todo.getStatus());
        return todoDto;
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = convertToEntity(todoDto);
        Todo savedTodo = todoRepository.save(todo);

        return convertToDto(savedTodo);
    }

    public List<TodoDto> getAllTodoList(){
        List<Todo> todo = todoRepository.findAll();
        return todo.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
    }

    public TodoDto getTodoById(Long id){
        Optional<Todo> findTodo = todoRepository.findById(id);
        if(findTodo.isPresent()){
            Todo todo =  findTodo.get();

            return convertToDto(todo);
        } else{
            return null;
        }
    }

    public TodoDto updateTodo(Long id, TodoDto todoDto){
        Optional<Todo> findTodo = todoRepository.findById(id);
        if(findTodo.isPresent()){
            Todo todo = findTodo.get();
            todo.setTitle(todoDto.getTitle());
            todo.setDescription(todoDto.getDescription());
            todo.setStatus(todoDto.getStatus());

            Todo updateTodo = todoRepository.save(todo);
            return convertToDto(updateTodo);
        } else{
            return null;
        }
    }

    public boolean deleteTodo(Long id){
        Optional<Todo> findTodo = todoRepository.findById(id);
        if(findTodo.isPresent()){
            todoRepository.delete(findTodo.get());
            return true;
        } else {
            return false;
        }
    }
}
