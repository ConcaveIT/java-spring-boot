package com.advpro.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.advpro.payment.model.PaymentType;
import com.advpro.payment.dto.PaymentTypeDto;
import com.advpro.payment.service.PaymentTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment-types")
public class PaymentTypeController {    

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping
    public ResponseEntity<List<PaymentType>> getAllPaymentTypes(){
        return ResponseEntity.ok(paymentTypeService.getAllPaymentTypes());
    }

    @PostMapping
    public ResponseEntity<PaymentType> storePaymentType(@RequestBody PaymentTypeDto paymentTypeDto) {
        return new ResponseEntity<>(paymentTypeService.storePaymentType(paymentTypeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentType> getPaymentType(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(paymentTypeService.getPaymentType(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentType> updatePaymentType(
    	@PathVariable("id") Integer id, 
    	@RequestBody PaymentTypeDto paymentTypeDto
    ) {
        return ResponseEntity.ok(paymentTypeService.updatePaymentType(id, paymentTypeDto));
    }

    @DeleteMapping("/{id}")
    public String deletePaymentType(@PathVariable("id") Integer id){
        paymentTypeService.deletePaymentType(id);

        return "PaymentType item Deleted Successfully!";
    }
    
}