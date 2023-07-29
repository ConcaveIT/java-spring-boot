package com.todo.todo.dto;

public class TodoCustomResponseDto {
    
    private boolean success;
	private String message;
	
	public TodoCustomResponseDto(boolean success, String message)
	{
		super();
		this.success = success;
		this.message = message;
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
}
