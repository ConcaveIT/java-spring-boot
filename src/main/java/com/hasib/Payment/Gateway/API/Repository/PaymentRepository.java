package com.hasib.Payment.Gateway.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hasib.Payment.Gateway.API.Entity.PaymentType;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentType, Long>{
    
}
