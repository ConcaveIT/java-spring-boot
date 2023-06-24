package com.topic02.paymentgateway.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topic02.paymentgateway.entity.PaymentType;
import com.topic02.paymentgateway.service.PaymentTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment-types")
public class PaymentTypeController {

  @Autowired
  private PaymentTypeService paymentTypeService;

  private final Logger LOGGER = LoggerFactory.getLogger(PaymentTypeController.class);

  @PostMapping("")
  public PaymentType savePaymentType(@Valid @RequestBody PaymentType paymentType) {
    LOGGER.info("Inside savePaymentType method of PaymentTypeController class");
    return paymentTypeService.savePaymentType(paymentType);
  }

  @GetMapping("")
  public List<PaymentType> getAllPaymentTypes() {
    LOGGER.info("Inside getAllPaymentTypes method of PaymentTypeController class");
    return paymentTypeService.fetchAllPaymentTypes();
  }

  @GetMapping("/{id}")
  public PaymentType getPaymentTypeById(@PathVariable("id") Long id) {
    LOGGER.info("Inside getPaymentTypeById method of PaymentTypeController class");
    return paymentTypeService.getPaymentTypeById(id);
  }

  @PutMapping("/{id}")
  public PaymentType updatePaymentTypeById(@PathVariable("id") Long id, @RequestBody PaymentType paymentType) {
    LOGGER.info("Inside updatePaymentTypeById method of PaymentTypeController class");
    return paymentTypeService.updatePaymentTypeById(id, paymentType);
  }

  @DeleteMapping("/{id}")
  public PaymentType deletePaymentTypeById(@PathVariable("id") Long id) {
    LOGGER.info("Inside deletePaymentTypeById method of PaymentTypeController class");
    return paymentTypeService.deletePaymentTypeById(id);
  }

}
