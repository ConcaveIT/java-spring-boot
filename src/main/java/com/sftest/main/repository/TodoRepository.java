package com.sftest.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sftest.main.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	public boolean existsById(Integer  id);
	
	public List<Todo> findByTodoId(Integer id);
	
	@Query("select ma(s.id) from todo s")
	public Integer findMaxId();
}
