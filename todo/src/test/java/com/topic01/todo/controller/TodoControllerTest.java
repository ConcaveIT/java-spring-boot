package com.topic01.todo.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topic01.todo.entity.Todo;
import com.topic01.todo.service.TodoServiceImp;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @MockBean
    TodoServiceImp todoService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_findAllTodos() throws Exception {
        List<Todo> todo = Arrays.asList(new Todo(null, "Lipsa", "Patra", 1, null, null),
                new Todo(null, "Robert", "Frost", 1, null, null));

        when(todoService.findAllTodos()).thenReturn(todo);
        RequestBuilder request = MockMvcRequestBuilders.get("/todos")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void test_createTodo() throws Exception {
        Todo todo = new Todo(null, "test1", null, 1, null, null);
        when(todoService.saveTodo(todo)).thenReturn(todo);
        RequestBuilder request = MockMvcRequestBuilders.post("/todos")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(todo));
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void test_findTodoById() {

    }

    @Test
    public void test_updateTodoById() {

    }

    @Test
    public void test_deleteTodo() {

    }
}
