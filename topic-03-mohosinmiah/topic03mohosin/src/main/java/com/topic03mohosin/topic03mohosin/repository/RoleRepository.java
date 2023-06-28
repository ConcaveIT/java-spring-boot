package com.topic03mohosin.topic03mohosin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topic03mohosin.topic03mohosin.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
     
    Optional<Role> findByName(String name);
}
