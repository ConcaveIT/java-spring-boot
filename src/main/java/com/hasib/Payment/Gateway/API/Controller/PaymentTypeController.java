package com.hasib.Payment.Gateway.API.Controller;

import java.util.Collections;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hasib.Payment.Gateway.API.Dto.PaymentTypeRequestDto;
import com.hasib.Payment.Gateway.API.Service.PaymentTypeService;



@RestController
@RequestMapping("/api/v1/payment-type")
public class PaymentTypeController {
    
    private PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Payment Type Service is up and running");
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPaymentType(@Valid @RequestBody PaymentTypeRequestDto paymentTypeRequestDto, BindingResult bindingResult) {
        // try{
            if(bindingResult.hasErrors()) {

                String errorMessage = bindingResult.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", errorMessage));
            }
            else {
                PaymentTypeRequestDto createPaymentType = paymentTypeService.createPaymentType(paymentTypeRequestDto);
                return ResponseEntity.ok(createPaymentType);
            }
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body(e.getMessage());
        // }
    }
}
