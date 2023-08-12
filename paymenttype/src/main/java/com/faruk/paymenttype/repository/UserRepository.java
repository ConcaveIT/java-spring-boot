package com.faruk.paymenttype.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faruk.paymenttype.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
