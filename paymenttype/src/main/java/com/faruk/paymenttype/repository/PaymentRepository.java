package com.faruk.paymenttype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faruk.paymenttype.entity.PaymentType;


public interface PaymentRepository extends JpaRepository<PaymentType, Long> {
   
}


