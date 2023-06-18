package com.practice.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.practice.todo.controller.TodoController;
import com.practice.todo.entity.Todo;
import com.practice.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoController todoController;

    @Test
    public void createTodo_shouldReturnCreatedTodo() {
        // Arrange
        Todo todo = new Todo();
        todo.setTitle("Buy groceries");
        todo.setDescription("Milk, eggs, bread");

        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        // Act
        ResponseEntity<Todo> response = todoController.createTodo(todo);

        // Assert
        verify(todoRepository).save(any(Todo.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(todo, response.getBody());
    }

    @Test
    public void getAllTodos_shouldReturnListOfTodos() {
        // Arrange
        Todo todo1 = new Todo();
        todo1.setId(1L);
        todo1.setTitle("Buy groceries");
        todo1.setDescription("Milk, eggs, bread");

        Todo todo2 = new Todo();
        todo2.setId(2L);
        todo2.setTitle("Read a book");
        todo2.setDescription("Choose a good novel");

        when(todoRepository.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        // Act
        List<Todo> todos = todoController.getAllTodos();

        // Assert
        verify(todoRepository).findAll();
        assertEquals(2, todos.size());
        assertEquals(todo1, todos.get(0));
        assertEquals(todo2, todos.get(1));
    }

    @Test
    public void getTodoById_existingId_shouldReturnTodo() {
        // Arrange
        Long todoId = 1L;
        Todo todo = new Todo();
        todo.setId(todoId);
        todo.setTitle("Buy groceries");
        todo.setDescription("Milk, eggs, bread");

        when(todoRepository.findById(eq(todoId))).thenReturn(Optional.of(todo));

        // Act
        ResponseEntity<Todo> response = todoController.getTodoById(todoId);

        // Assert
        verify(todoRepository).findById(eq(todoId));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(todo, response.getBody());
    }

    @Test
    public void getTodoById_nonExistingId_shouldReturnNotFound() {
        // Arrange
        Long todoId = 1L;

        when(todoRepository.findById(eq(todoId))).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Todo> response = todoController.getTodoById(todoId);

        // Assert
        verify(todoRepository).findById(eq(todoId));
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Additional test cases for updateTodo and deleteTodoById can be added similarly
}
