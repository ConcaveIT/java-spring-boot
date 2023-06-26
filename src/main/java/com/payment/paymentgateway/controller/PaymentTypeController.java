package com.payment.paymentgateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.paymentgateway.entity.PaymentType;
import com.payment.paymentgateway.service.PaymentTypeService;

@RestController
@RequestMapping("/api/v1")
public class PaymentTypeController {

    @Autowired
    PaymentTypeService paymentTypeService;

    @GetMapping("/health")
    public String showAppHealth(){
        return "ok !!";
    }

    @GetMapping("/payment-types")
    public ResponseEntity<List<PaymentType>> getAllPaymentType() {
        return paymentTypeService.getAllPaymentType();
	}

    @PostMapping("/payment-types")
    public ResponseEntity<PaymentType> savePaymentType(@RequestBody PaymentType paymentType){
        return paymentTypeService.savePaymentType(paymentType);
    }

    @GetMapping("/payment-types/{id}")
    public ResponseEntity<PaymentType> gePaymentType(@PathVariable Long id) {
        return paymentTypeService.getPaymentType(id);
	}

    @PutMapping("/payment-types/{id}")
	public ResponseEntity<PaymentType> updatePaymentType(@PathVariable Long id,@RequestBody PaymentType paymentType) {
        return paymentTypeService.updatePaymentType(id, paymentType);
	}


    @DeleteMapping("/payment-types/{id}")
	public ResponseEntity<HttpStatus> deletePaymentType(@PathVariable Long id) {
        return paymentTypeService.deletePaymentType(id);
    }
}
