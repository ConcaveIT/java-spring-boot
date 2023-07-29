package com.todo.todo.dto;

import com.todo.todo.model.Todo;

public class TodoCreateUpdateResponseDto {

    private Todo todo;
	private boolean success;
	private String message;
	
	public TodoCreateUpdateResponseDto(Todo todo ,boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
		this.todo = todo;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    public Todo getTodo() {
		return todo;
	}
	public void setTodo(Todo todo) {
		this.todo = todo;
	}
    
}
