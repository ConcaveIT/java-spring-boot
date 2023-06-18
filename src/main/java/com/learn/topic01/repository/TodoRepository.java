package com.learn.topic01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.topic01.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    // Additional custom query methods or repository operations can be defined here
    public static String noDataFound() {
        return "No Data Found.";
    }
}

