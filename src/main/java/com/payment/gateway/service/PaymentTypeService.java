package com.payment.gateway.service;

import com.payment.gateway.entity.PaymentType;
import com.payment.gateway.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;

    @Autowired
    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    public PaymentType createPaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    public PaymentType getPaymentTypeById(Long id) {
        return paymentTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment type not found"));
    }

    public PaymentType updatePaymentType(Long id, PaymentType updatedPaymentType) {
        PaymentType paymentType = getPaymentTypeById(id);
        paymentType.setName(updatedPaymentType.getName());
        paymentType.setDescription(updatedPaymentType.getDescription());
        return paymentTypeRepository.save(paymentType);
    }

    public void deletePaymentType(Long id) {
        paymentTypeRepository.deleteById(id);
    }
}
