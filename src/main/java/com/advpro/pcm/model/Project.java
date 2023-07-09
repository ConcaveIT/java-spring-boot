package com.advpro.pcm.model;

import com.advpro.pcm.model.enumtype.ProjectStatus;

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
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@Column(nullable = false, length = 200)
	private String name;

	@Column(nullable = false, length = 2000)
	private String description;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ProjectStatus status;

	@Basic(optional = false)
	@Column(name = "StartDate")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Basic(optional = false)
	@Column(name = "EndDate")
	@Temporal(TemporalType.DATE)
	private Date endDate;

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