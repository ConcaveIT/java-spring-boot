package com.hasib.Payment.Gateway.API.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<?> createPaymentType(@Valid @RequestBody PaymentTypeRequestDto paymentTypeRequestDto,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {

                String errorMessage = bindingResult.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", "));
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", errorMessage));
            } else {
                PaymentTypeRequestDto createPaymentType = paymentTypeService.createPaymentType(paymentTypeRequestDto);
                return ResponseEntity.ok(createPaymentType);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentTypeRequestDto>> getAllPaymentType() {
        try {
            List<PaymentTypeRequestDto> paymentTypeRequestDto = paymentTypeService.getAllPaymentType();
            return ResponseEntity.ok(paymentTypeRequestDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonList(new PaymentTypeRequestDto()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentTypeRequestDto> getPaymentTypeById(@PathVariable Long id) {

        PaymentTypeRequestDto paymentTypeRequestDto = paymentTypeService.getPaymentTypeById(id);
        if (paymentTypeRequestDto != null) {
            return ResponseEntity.ok(paymentTypeRequestDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PaymentTypeRequestDto> updatePaymentType(@PathVariable Long id,
            @Valid @RequestBody PaymentTypeRequestDto paymentTypeRequestDto, BindingResult bindingResult) {

        PaymentTypeRequestDto updatePaymentType = paymentTypeService.updatePaymentType(id, paymentTypeRequestDto);
        if (updatePaymentType != null) {
            return ResponseEntity.ok(updatePaymentType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaymentType(@PathVariable Long id) {
        boolean isDeleted = paymentTypeService.deletePaymentType(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
