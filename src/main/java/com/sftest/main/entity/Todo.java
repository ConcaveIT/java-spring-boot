package com.sftest.main.entity;

import jakarta.persistence.Id;

public class Todo {
	 	@Id
	    private int id;

	    private String title;

	    private String description;

		private String status;

	    public Todo() {
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

		public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "Student{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", description='" + description + '\'' +
					", status='" + status + '\'' +
	                '}';
	    }
}
