package com.advpro.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name="paymentTypes")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

	@Basic(optional = true)
	@Column(name = "DeletedAt", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;

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