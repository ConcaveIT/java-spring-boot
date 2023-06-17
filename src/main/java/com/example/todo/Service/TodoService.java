package com.example.todo.Service;

import com.example.todo.Entity.Todo;
import com.example.todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public String createTodo(Todo todo){
        try {
            if (!todoRepository.existsByTitle(todo.getTitle())){
                todo.setId(null == todoRepository.findMaxId()? 0 : todoRepository.findMaxId() + 1);
                todoRepository.save(todo);
                return "todo record created successfully.";
            }else {
                return "todo already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Todo> readTodos(){
        return todoRepository.findAll();
    }

    @Transactional
    public String updateTodo(Todo todo){
        if (todoRepository.existsByTitle(todo.getTitle())){
            try {
                List<Todo> todos = todoRepository.findByTitle(todo.getTitle());
                todos.stream().forEach(s -> {
                    Todo todoToBeUpdate = todoRepository.findById(s.getId()).get();
                    todoToBeUpdate.setTitle(todo.getTitle());
                    todoToBeUpdate.setDescription(todo.getDescription());

                    todoRepository.save(todoToBeUpdate);
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
        if (todoRepository.existsByTitle(todo.getTitle())){
            try {
                List<Todo> todos = todoRepository.findByTitle(todo.getTitle());
                todos.stream().forEach(s -> {
                    todoRepository.delete(s);
                });
                return "Todo record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Todo does not exist";
        }
    }
}