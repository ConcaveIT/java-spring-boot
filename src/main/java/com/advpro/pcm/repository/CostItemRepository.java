package com.advpro.pcm.repository;

import com.advpro.pcm.model.CostItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostItemRepository extends JpaRepository<CostItem, Integer> {

}