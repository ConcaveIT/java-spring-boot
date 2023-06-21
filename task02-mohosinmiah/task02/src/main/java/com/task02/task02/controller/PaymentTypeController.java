package com.task02.task02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task02.task02.entity.PaymentType;
import com.task02.task02.repository.PaymentTypeRepository;
import com.task02.task02.service.PaymentTypeService;

@RestController
@RequestMapping("/api/v1/payment-types")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;


    @GetMapping
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeService.getAllPaymentTypes();
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentTypeById(@PathVariable Long id) {
        return paymentTypeService.getPaymentTypeById(id);
    }

    @PostMapping
    public PaymentType createPaymentType(@RequestBody PaymentType paymentType) {
        return paymentTypeService.createPaymentType(paymentType);
    }

    @PutMapping("/{id}")
    public PaymentType updatePaymentType(@PathVariable Long id, @RequestBody PaymentType paymentType) {
        return paymentTypeService.updatePaymentType(id, paymentType);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentType(@PathVariable Long id) {
        paymentTypeService.deletePaymentType(id);
    }
}