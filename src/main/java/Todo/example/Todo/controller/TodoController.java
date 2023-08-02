package Todo.example.Todo.controller;

import Todo.example.Todo.dto.TodoDto;
import Todo.example.Todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    @Autowired
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoDto> getList() {
        return todoService.getList();
    }

    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(todoService.create(todoDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update(@RequestBody TodoDto todoDto, @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(todoService.update(todoDto, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        todoService.deleteById(id);
        return ResponseEntity.ok("Todo Deleted successfully");
    }
}
