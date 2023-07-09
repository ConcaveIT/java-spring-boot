package com.advpro.pcm.model;

import com.advpro.pcm.model.enumtype.Role;
import com.advpro.pcm.model.enumtype.Department;
import com.advpro.pcm.model.enumtype.MemberStatus;

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
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable=false, unique=true, length = 200)
    private String email;

    @Column(nullable=false, length = 50)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

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