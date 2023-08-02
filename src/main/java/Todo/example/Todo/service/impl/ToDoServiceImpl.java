package Todo.example.Todo.service.impl;

import Todo.example.Todo.dto.TodoDto;
import Todo.example.Todo.entity.Todo;
import Todo.example.Todo.repository.TodoRepository;
import Todo.example.Todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    public ToDoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public TodoDto create(TodoDto todoDto) {
        Todo todo1 = mapToEntity(todoDto);
        Todo todo2 = todoRepository.save(todo1);
        return mapToDto(todo2);


    }

    @Override
    public TodoDto update(TodoDto todoDto, long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setStatus(todoDto.getStatus());
        Todo updatedTodo = todoRepository.save(todo);
        return mapToDto(updatedTodo);

    }

    @Override
    public List<TodoDto> getList() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto getById(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        return mapToDto(todo);
    }

    @Override
    public void deleteById(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todoRepository.delete(todo);
    }

    private TodoDto mapToDto(Todo todo) {
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setStatus(todo.getStatus());
        return todoDto;
    }
    private Todo mapToEntity(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setStatus(todoDto.getStatus());

        return todo;
    }

}
