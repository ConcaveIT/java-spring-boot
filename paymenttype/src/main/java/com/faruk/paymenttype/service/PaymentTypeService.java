package com.faruk.paymenttype.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faruk.paymenttype.dto.PaymentRequest;
import com.faruk.paymenttype.entity.PaymentType;



@Service
public interface PaymentTypeService {
    
    public List<PaymentRequest> getAllPayments();
    public PaymentType savePayment(PaymentType paymentType);
    public PaymentType updatePaymentType(Long Id, PaymentType paymentType);
    public PaymentType deletePaymentType(Long Id);
    public PaymentType getSinglePaymentType(Long Id);

}
