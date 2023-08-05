package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.PaymentType;
import com.payment.service.PaymentTypeService;

@RestController
@RequestMapping("/api/payments")
public class PaymentTypeController {
	
	@Autowired
	@Qualifier("paymentTypeService")
    private PaymentTypeService paymentTypeService;

    @GetMapping
    public List<PaymentType> getAllPayments() {
        return paymentTypeService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentById(@PathVariable Long id) {
        return paymentTypeService.getPaymentById(id);
    }

    @PostMapping
    public PaymentType createPayment(@RequestBody PaymentType payment) {
        return paymentTypeService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public PaymentType updatePayment(@PathVariable Long id, @RequestBody PaymentType paymentDetails) {
        return paymentTypeService.updatePayment(id, paymentDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentTypeService.deletePayment(id);
    }
}
