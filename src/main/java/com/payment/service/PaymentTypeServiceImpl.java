package com.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.payment.model.PaymentType;
import com.payment.repository.PaymentTypeRepository;

public class PaymentTypeServiceImpl implements PaymentTypeService{
	@Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAllPayments() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getPaymentById(Long id) {
        return paymentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentType createPayment(PaymentType payment) {
        return paymentTypeRepository.save(payment);
    }

    @Override
    public PaymentType updatePayment(Long id, PaymentType paymentDetails) {
        PaymentType payment = paymentTypeRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.setName(paymentDetails.getName());
            payment.setDescription(paymentDetails.getDescription());
            return paymentTypeRepository.save(payment);
        }
        return null;
    }

    @Override
    public void deletePayment(Long id) {
        paymentTypeRepository.deleteById(id);
    }
}
