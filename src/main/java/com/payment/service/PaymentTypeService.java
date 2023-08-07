package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.payment.model.PaymentType;
import com.payment.repository.PaymentTypeRepository;

public class PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;
    
    @Autowired
    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }
    
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    public Optional<PaymentType> getPaymentTypeById(Long id) {
        return paymentTypeRepository.findById(id);
    }

    public PaymentType savePaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    public void deletePaymentType(Long id) {
        paymentTypeRepository.deleteById(id);
    }
}
