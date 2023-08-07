package com.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/payment-types")
public class PaymentTypeController {
	
	private final PaymentTypeService paymentTypeService;
	
	@Autowired
    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }
	
	@GetMapping
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeService.getAllPaymentTypes();
    }

	@GetMapping("/{id}")
    public Optional<PaymentType> getPaymentTypeById(@PathVariable Long id) {
        return paymentTypeService.getPaymentTypeById(id);
    }

    @PostMapping
    public PaymentType createPaymentType(@RequestBody PaymentType paymentType) {
        return paymentTypeService.savePaymentType(paymentType);
    }

    @PutMapping("/{id}")
    public PaymentType updatePaymentType(@PathVariable Long id, @RequestBody PaymentType paymentType) {
        paymentType.setId(id);
        return paymentTypeService.savePaymentType(paymentType);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentType(@PathVariable Long id) {
        paymentTypeService.deletePaymentType(id);
    }
}
