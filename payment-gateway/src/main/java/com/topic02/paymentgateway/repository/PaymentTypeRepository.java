package com.topic02.paymentgateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topic02.paymentgateway.entity.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long>  {

}
