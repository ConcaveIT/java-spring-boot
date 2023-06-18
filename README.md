# Simple Rest TODO list 

**Endpoints**
- GET /todos: Retrieve all todos
- POST /todos: Create a new todo
- GET /todos/{id}: Retrieve a specific todo by ID
- PUT /todos/{id}: Update a specific todo by ID
- DELETE /todos/{id}: Delete a specific todo by ID

**Body Data (POST / PUT)**
```
{
    "title":"yo todo 2",
    "description":"First todo description 222",
    "status": true
}
```