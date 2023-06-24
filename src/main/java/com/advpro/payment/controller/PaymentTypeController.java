package com.advpro.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.advpro.payment.model.PaymentType;
import com.advpro.payment.service.PaymentTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment-types")
public class PaymentTypeController {    

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping
    public List<PaymentType> getAllPaymentTypes(){
        return paymentTypeService.getAllPaymentTypes();
    }

    @PostMapping
    public PaymentType storePaymentType(@RequestBody PaymentType paymentType) {
        return paymentTypeService.storePaymentType(paymentType);
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentType(@PathVariable("id") Integer id) {
        return paymentTypeService.getPaymentType(id);
    }

    @PutMapping("/{id}")
    public PaymentType updatePaymentType(
    	@PathVariable("id") Integer id, 
    	@RequestBody PaymentType paymentType
    ) {
        return paymentTypeService.updatePaymentType(paymentType);
    }

    @DeleteMapping("/{id}")
    public String deletePaymentType(@PathVariable("id") Integer id){
        paymentTypeService.deletePaymentType(id);

        return "PaymentType item Deleted Successfully!";
    }
    
}