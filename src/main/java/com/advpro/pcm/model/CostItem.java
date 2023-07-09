package com.advpro.pcm.model;

import com.advpro.pcm.model.enumtype.CostItemStatus;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name="costItems")
public class CostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 2000)
	private String description;

	@Column(nullable = false)
	private Float amount;

	@Column(nullable = false)
	private Integer costCategoryId;

	@Column(nullable = false)
	private Integer projectId;

	@Column(nullable = false)
	private Integer entryBy;

	@Column
	private Integer approvedBy;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CostItemStatus status;

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

}