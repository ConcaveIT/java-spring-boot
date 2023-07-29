package com.todo.todo.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.dto.TodoDto;
import com.todo.todo.model.Todo;
import com.todo.todo.repository.TodoRepository;
import com.todo.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
    
    @Autowired
	TodoRepository todoRepository;

	@Override
	public List<TodoDto> getAllTodos() {
		List<Todo> todos = todoRepository.findAll();
		return todos.stream().map(TodoDto::new ).collect(Collectors.toList());
	}

    @Override
	public Todo saveTodo(Todo todo) {
		Todo newTodo = new Todo();
		newTodo.setTitle(todo.getTitle()); 
		newTodo.setDescription(todo.getDescription());
		newTodo.setStatus(todo.getStatus());
		todoRepository.save(newTodo);

		return newTodo;
	}

    @Override
    public Todo getSingleTodo(Long Id)
    {
        Todo singleTodo = todoRepository.findById(Id).get();
        if(singleTodo !=null) {
            
			return singleTodo;
		}

		return null;
		
    }


    @Override
	public Todo updateTodo(Long Id, Todo todo) {
        Todo updateTodo = todoRepository.findById(Id).get();
		updateTodo.setTitle(todo.getTitle()); 
		updateTodo.setDescription(todo.getDescription());
		updateTodo.setStatus(todo.getStatus());
		todoRepository.save(updateTodo);

		return updateTodo;
	}


    @Override

    public Todo deleteTodo(Long Id) {
		Todo deleteTodo = todoRepository.findById(Id).get();
		if(deleteTodo !=null) {
			todoRepository.deleteById(Id);

			return deleteTodo;
		}

		return null;
	}

}
