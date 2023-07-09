package com.advpro.pcm.repository;

import com.advpro.pcm.model.CostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostCategoryRepository extends JpaRepository<CostCategory, Integer> {

}
