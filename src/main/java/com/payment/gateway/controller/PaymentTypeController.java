package com.payment.gateway.controller;

import com.payment.gateway.entity.PaymentType;
import com.payment.gateway.service.PaymentTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-types")
public class PaymentTypeController {
    private final PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeService.getAllPaymentTypes();
    }

    @PostMapping
    public PaymentType createPaymentType(@Valid @RequestBody PaymentType paymentType) {
        return paymentTypeService.createPaymentType(paymentType);
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentTypeById(@PathVariable Long id) {
        return paymentTypeService.getPaymentTypeById(id);
    }

    @PutMapping("/{id}")
    public PaymentType updatePaymentType(@PathVariable Long id, @Valid @RequestBody PaymentType paymentType) {
        return paymentTypeService.updatePaymentType(id, paymentType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentType(@PathVariable Long id) {
        paymentTypeService.deletePaymentType(id);
        return ResponseEntity.noContent().build();
    }
}
