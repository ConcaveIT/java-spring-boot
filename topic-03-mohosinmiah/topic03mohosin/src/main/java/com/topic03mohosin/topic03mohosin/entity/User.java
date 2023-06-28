package com.topic03mohosin.topic03mohosin.entity;

import java.util.Set;

import com.topic03mohosin.topic03mohosin.dto.RoleDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "users"

)
public class User {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long Id;
    private String memberName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String department;

    private String status;

    @ManyToMany(
        fetch   = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinTable(
        name        = "user_roles",
        joinColumns = @JoinColumn(
            name                 = "user_id",
            referencedColumnName = "Id"
        ),
        inverseJoinColumns = @JoinColumn(
            name                 = "role_id",
            referencedColumnName = "Id"
        )
    )
    private Set<Role> roles;
}