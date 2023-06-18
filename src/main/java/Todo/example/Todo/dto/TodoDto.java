package Todo.example.Todo.dto;

import lombok.Data;

@Data
public class TodoDto {
    private long id;
    private String title;
    private String description;
    private int status;
}
