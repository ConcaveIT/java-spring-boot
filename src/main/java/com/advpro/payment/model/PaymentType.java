package com.advpro.payment.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name="paymentTypes")
public class PaymentType {

    @Id
    @GeneratedValue
    private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, length = 2000)
	private String description;

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

	public PaymentType(
		String name, 
		String description, 
		Date createdAt, 
		Date updatedAt, 
		Date deletedAt
	) {
	    this.name = name;
	    this.description = description;
	    this.createdAt = createdAt;
	    this.updatedAt = updatedAt;
	}

	protected PaymentType() {
		// NoArgsConstructor
	}

	public Integer getId() {
	    return id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public Date getCreatedAt() {
	    return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
	    this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
	    return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
	    this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
	    return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
	    this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
	    return "PaymentType{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", description='" + description + '\'' +
	            ", createdAt=" + createdAt +
	            ", updatedAt='" + updatedAt + '\'' +
	            ", deletedAt=" + deletedAt +
	            '}';
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    PaymentType todo = (PaymentType) o;
	    return Objects.equals(id, todo.id) &&
	            Objects.equals(name, todo.name) &&
	            Objects.equals(description, todo.description) &&
	            Objects.equals(createdAt, todo.createdAt) &&
	            Objects.equals(updatedAt, todo.updatedAt) &&
	            Objects.equals(deletedAt, todo.deletedAt);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id, name, description, createdAt, updatedAt, deletedAt);
	}
	
}