package com.topic02.paymentgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-types")
public class PaymentTypeController {

  @GetMapping("")
  public String test() {
    return "Testing";
  }

}
