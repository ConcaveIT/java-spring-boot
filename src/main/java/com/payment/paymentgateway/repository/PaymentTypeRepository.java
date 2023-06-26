package com.payment.paymentgateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.paymentgateway.entity.PaymentType;


public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long>{
    
}
