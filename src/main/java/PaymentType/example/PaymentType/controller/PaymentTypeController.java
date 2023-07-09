package paymentType.example.paymentType.controller;

import paymentType.example.paymentType.exception.PaymentTypeNotFoundException;
import paymentType.example.paymentType.service.PaymentTypeService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import paymentType.example.paymentType.dto.PaymentTypeDto;

import java.util.List;

@RestController
@RequestMapping("api/payment-types")
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping
    public List<PaymentTypeDto> getList() {
        return paymentTypeService.getList();
    }

    @PostMapping
    public ResponseEntity<PaymentTypeDto> create(@Valid @RequestBody PaymentTypeDto paymentTypeDto)  {
        return new ResponseEntity<>(paymentTypeService.create(paymentTypeDto), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<PaymentTypeDto> update( @RequestBody PaymentTypeDto paymentTypeDto,
                                                 @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(paymentTypeService.update(paymentTypeDto, id));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) throws PaymentTypeNotFoundException {

        return ResponseEntity.ok(paymentTypeService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) throws PaymentTypeNotFoundException {

        paymentTypeService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
