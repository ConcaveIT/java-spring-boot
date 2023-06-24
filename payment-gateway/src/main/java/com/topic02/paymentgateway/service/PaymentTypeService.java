package com.topic02.paymentgateway.service;

import java.util.List;

import com.topic02.paymentgateway.entity.PaymentType;

public interface PaymentTypeService {
  PaymentType savePaymentType(PaymentType paymentType);
  List<PaymentType> fetchAllPaymentTypes();
  PaymentType getPaymentTypeById(Long id);
  PaymentType updatePaymentTypeById(Long id, PaymentType paymentType);
  PaymentType deletePaymentTypeById(Long id);
}
