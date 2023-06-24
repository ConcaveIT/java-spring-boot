package com.advpro.payment.service;

import com.advpro.payment.model.PaymentType;
import com.advpro.payment.dto.PaymentTypeDto;

import java.util.List;

public interface PaymentTypeService {

    public PaymentType storePaymentType(PaymentTypeDto paymentTypeDto);

    public PaymentType updatePaymentType(Integer id, PaymentTypeDto paymentTypeDto);

    public String deletePaymentType(Integer id);

    public PaymentType getPaymentType(Integer id);
    
    public List<PaymentType> getAllPaymentTypes();

}
