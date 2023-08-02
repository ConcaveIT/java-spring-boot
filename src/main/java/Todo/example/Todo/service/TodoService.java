package Todo.example.Todo.service;

import Todo.example.Todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto create(TodoDto todoDto);

    TodoDto update(TodoDto todoDto, long id);

    List<TodoDto> getList();

    TodoDto getById(long id);

    void deleteById(long id);
}
