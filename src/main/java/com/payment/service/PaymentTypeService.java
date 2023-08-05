package com.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.model.PaymentType;

@Service
public interface PaymentTypeService {
	List<PaymentType> getAllPayments();
    PaymentType getPaymentById(Long id);
    PaymentType createPayment(PaymentType payment);
    PaymentType updatePayment(Long id, PaymentType paymentDetails);
    void deletePayment(Long id);
}
