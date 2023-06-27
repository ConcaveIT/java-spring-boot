package com.topic03mohosin.topic03mohosin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topic03mohosin.topic03mohosin.entity.CostItem;

@Repository
public interface CostItemRepository extends JpaRepository<CostItem, Long> {
}
