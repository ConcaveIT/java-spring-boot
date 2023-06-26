package com.payment.paymentgateway.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.paymentgateway.entity.PaymentType;


public interface PaymentTypeService {
    public ResponseEntity<List<PaymentType>> getAllPaymentType();
    public ResponseEntity<PaymentType> savePaymentType(@RequestBody PaymentType paymentType);
    public ResponseEntity<PaymentType> getPaymentType(@PathVariable Long id);
    public ResponseEntity<PaymentType> updatePaymentType(@PathVariable Long id,@RequestBody PaymentType paymentType);
    public ResponseEntity<HttpStatus> deletePaymentType(@PathVariable Long id);

}
