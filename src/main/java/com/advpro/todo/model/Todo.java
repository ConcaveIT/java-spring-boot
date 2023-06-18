package com.advpro.todo.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 2000)
	private String description;

	// 1 = Completed | 0 = Not Completed
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean status;

	@Basic(optional = false)
	@Column(name = "CreatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Basic(optional = false)
	@Column(name = "UpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Basic(optional = false)
	@Column(name = "DeletedAt", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;

	public Todo(
		String title, 
		String description, 
		Boolean status, 
		Date createdAt, 
		Date updatedAt, 
		Date deletedAt
	) {
	    this.title = title;
	    this.description = description;
	    this.status = status;
	    this.createdAt = createdAt;
	    this.updatedAt = updatedAt;
	}

	protected Todo()
	{
		// NoArgsConstructor
	}

	public Integer getId()
	{
	    return id;
	}

	public String getTitle()
	{
	    return title;
	}

	public void setTitle(String title)
	{
	    this.title = title;
	}

	public String getDescription()
	{
	    return description;
	}

	public void setDescription(String description)
	{
	    this.description = description;
	}

	public Boolean getStatus()
	{
	    return status;
	}

	public void setStatus(Boolean status)
	{
	    this.status = status;
	}

	public Date getCreatedAt()
	{
	    return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
	    this.createdAt = createdAt;
	}

	public Date getUpdatedAt()
	{
	    return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt)
	{
	    this.updatedAt = updatedAt;
	}

	public Date getDeletedAt()
	{
	    return deletedAt;
	}

	public void setDeletedAt(Date deletedAt)
	{
	    this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
	    return "Todo{" +
	            "id=" + id +
	            ", title='" + title + '\'' +
	            ", description='" + description + '\'' +
	            ", status='" + status + '\'' +
	            ", createdAt=" + createdAt +
	            ", updatedAt='" + updatedAt + '\'' +
	            ", deletedAt=" + deletedAt +
	            '}';
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Todo todo = (Todo) o;
	    return Objects.equals(id, todo.id) &&
	            Objects.equals(title, todo.title) &&
	            Objects.equals(description, todo.description) &&
	            Objects.equals(status, todo.status) &&
	            Objects.equals(createdAt, todo.createdAt) &&
	            Objects.equals(updatedAt, todo.updatedAt) &&
	            Objects.equals(deletedAt, todo.deletedAt);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id, title, description, status, createdAt, updatedAt, deletedAt);
	}
	
}