package com.advpro.payment.repository;

import com.advpro.payment.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

}
