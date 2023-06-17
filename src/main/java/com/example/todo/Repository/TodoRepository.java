package com.example.todo.Repository;

import com.example.todo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public boolean existsByDescription(String description);

    public List<Todo> findByTitle(String title);

    @Query("select max(s.id) from Todo s")
    public Integer findMaxId();

    public boolean existsByTitle(String title);
}