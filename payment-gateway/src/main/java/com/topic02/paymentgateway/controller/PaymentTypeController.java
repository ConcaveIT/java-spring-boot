package com.topic02.paymentgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topic02.paymentgateway.entity.PaymentType;
import com.topic02.paymentgateway.service.PaymentTypeService;

@RestController
// @RequestMapping("/payment-types")
public class PaymentTypeController {

  @Autowired
  private PaymentTypeService paymentTypeService;

  @PostMapping("/payment-types")
  public PaymentType savePaymentType(@RequestBody PaymentType paymentType) {
    return paymentTypeService.savePaymentType(paymentType);
    // return paymentType;
  }

}
