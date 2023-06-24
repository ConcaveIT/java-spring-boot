package com.advpro.payment.service;

import com.advpro.payment.model.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    public PaymentType storePaymentType(PaymentType PaymentType);

    public PaymentType updatePaymentType(PaymentType PaymentType);

    public String deletePaymentType(Integer id);

    public PaymentType getPaymentType(Integer id);
    
    public List<PaymentType> getAllPaymentTypes();

}
