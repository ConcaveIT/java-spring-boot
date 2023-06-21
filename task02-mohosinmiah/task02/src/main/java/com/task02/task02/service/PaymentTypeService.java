package com.task02.task02.service;

import java.util.List;

import com.task02.task02.entity.PaymentType;

public interface PaymentTypeService {

    List<PaymentType> getAllPaymentTypes();

    PaymentType getPaymentTypeById(Long id);

    PaymentType createPaymentType(PaymentType paymentType);

    PaymentType updatePaymentType(Long id, PaymentType paymentType);

    void deletePaymentType(Long id);
}
