package com.topic02.paymentgateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic02.paymentgateway.entity.PaymentType;
import com.topic02.paymentgateway.repository.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

  @Autowired
  private PaymentTypeRepository paymentTypeRepository;

  @Override
  public PaymentType savePaymentType(PaymentType paymentType) {
    return paymentTypeRepository.save(paymentType);
  }

}
