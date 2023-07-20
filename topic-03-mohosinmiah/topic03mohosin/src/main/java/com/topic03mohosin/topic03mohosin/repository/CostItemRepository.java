package com.topic03mohosin.topic03mohosin.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topic03mohosin.topic03mohosin.entity.CostItem;

@Repository
public interface CostItemRepository extends JpaRepository<CostItem, Long> {

    List<CostItem> findAllByProjectIdAndDateBetween(long projectId, LocalDate startDate, LocalDate endDate);
}
