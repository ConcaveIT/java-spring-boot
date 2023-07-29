package com.sftest.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sftest.main.entity.Todo;
import com.sftest.main.repository.TodoRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoService {
	@Autowired
    private TodoRepository todoRepository;
	
	@Transactional
    public String createTodo(Todo todo){
        try {
            if (!todoRepository.existsById(todo.getId())){
                todo.setId(null == todoRepository.findMaxId()? 0 : todoRepository.findMaxId() + 1);
                todoRepository.save(todo);
                return "Todo record created successfully.";
            }else {
                return "Todo already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }
	
	public List<Todo> readTodo(){
        return todoRepository.findAll();
    }
	
	@Transactional
    public String updateTodo(Todo todo){
        if (todoRepository.existsById(todo.getId())){
            try {
                List<Todo> todos = todoRepository.findByTodoId(todo.getId());
                todos.stream().forEach(s -> {
                    Todo todoToBeUpdate = todoRepository.findByTodoId(s.getId()).get();
                    todoToBeUpdate.setTitle(todo.getTitle());
                    todoToBeUpdate.setDescription(todo.getDescription());
                    todoToBeUpdate.save(todoToBeUpdate);
                });
                return "Todo record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Todo does not exists in the database.";
        }
    }
	
	@Transactional
    public String deleteTodo(Todo todo){
        if (todoRepository.existsById(todo.getId())){
            try {
                List<Todo> todos = todoRepository.findByTodoId(todo.getId());
                todos.stream().forEach(s -> {
                    todoRepository.delete(s);
                });
                return "Student record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Student does not exist";
        }
    }
}
