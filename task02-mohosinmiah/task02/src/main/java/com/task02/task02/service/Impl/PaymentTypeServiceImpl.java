package com.task02.task02.service.Impl;

import com.task02.task02.entity.PaymentType;
import com.task02.task02.repository.PaymentTypeRepository;
import com.task02.task02.service.PaymentTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private  PaymentTypeRepository paymentTypeRepository;


    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getPaymentTypeById(Long id) {
        return paymentTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PaymentType not found with id: " + id));
    }

    @Override
    public PaymentType createPaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public PaymentType updatePaymentType(Long id, PaymentType paymentType) {
        PaymentType existingPaymentType = paymentTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PaymentType not found with id: " + id));

        existingPaymentType.setName(paymentType.getName());
        existingPaymentType.setDescription(paymentType.getDescription());

        return paymentTypeRepository.save(existingPaymentType);
    }

    @Override
    public void deletePaymentType(Long id) {
        paymentTypeRepository.deleteById(id);
    }

    
}
