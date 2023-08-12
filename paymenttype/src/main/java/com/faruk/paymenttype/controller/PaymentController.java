package com.faruk.paymenttype.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faruk.paymenttype.dto.PaymentCreateUpdateResponseDto;
import com.faruk.paymenttype.dto.PaymentCustomResponseDto;
import com.faruk.paymenttype.dto.PaymentRequest;
import com.faruk.paymenttype.entity.PaymentType;
import com.faruk.paymenttype.service.PaymentTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    private final  PaymentTypeService paymentTypeService;
	
	
	public PaymentController(PaymentTypeService paymentTypeService) {
		this.paymentTypeService = paymentTypeService;
	}


    @GetMapping(value="/payments")
	public ResponseEntity<?> getAllPayments(){
		List<PaymentRequest> payments = paymentTypeService.getAllPayments();
        if(payments.size() > 0){
            return  ResponseEntity.ok().body(payments);
        }else{
            PaymentCustomResponseDto  paymentCustomResponseDto;
            paymentCustomResponseDto = new PaymentCustomResponseDto(false, "Data Not Found");
			
            return ResponseEntity.badRequest().body(paymentCustomResponseDto);
        }
	}



    @PostMapping(value="/payments")
    public ResponseEntity<?> savePayment( @Validated @RequestBody PaymentType paymentType)
    {
        PaymentCreateUpdateResponseDto  paymentCreateUpdateResponseDto;

        try {
			PaymentType insertPayment =  paymentTypeService.savePayment(paymentType);
			if (insertPayment != null) {

                paymentCreateUpdateResponseDto = new PaymentCreateUpdateResponseDto(insertPayment,true, "Data Inserted Successfully");
                return ResponseEntity.ok().body(paymentCreateUpdateResponseDto);
			}

			paymentCreateUpdateResponseDto = new PaymentCreateUpdateResponseDto(null,false, "Something wrong ! Please insert all input field");
            return ResponseEntity.badRequest().body(paymentCreateUpdateResponseDto);

		}catch(Exception e) {

			paymentCreateUpdateResponseDto = new PaymentCreateUpdateResponseDto(null,false, "Something wrong ! Please insert all input field");
            return ResponseEntity.badRequest().body(paymentCreateUpdateResponseDto);

		}
    }



    @GetMapping(value = "/payments/{Id}")
    @JsonIgnore
    public ResponseEntity<?> getSinglePaymentType(@PathVariable("Id") Long Id)
    {
        PaymentCustomResponseDto  paymentCustomResponseDto;
        try {
			PaymentType paymentType =  paymentTypeService.getSinglePaymentType(Id);
			if (paymentType != null) {
                return  ResponseEntity.ok().body(paymentType);
			}

			paymentCustomResponseDto = new PaymentCustomResponseDto(false, "Data Not Found");
            return ResponseEntity.badRequest().body(paymentCustomResponseDto);

		}catch(Exception e) {

			paymentCustomResponseDto = new PaymentCustomResponseDto(false, "Data Not Found");
            return ResponseEntity.badRequest().body(paymentCustomResponseDto);
		}
       
    }
    


   @PutMapping(value = "/payments/{Id}")
    public ResponseEntity<?> updatePaymentType(@Validated @RequestBody PaymentType paymentType, @PathVariable("Id") Long Id)
	{
       PaymentCreateUpdateResponseDto  paymentCreateUpdateResponseDto;

        try {
			PaymentType updatePayment = paymentTypeService.updatePaymentType(Id,paymentType);
			if (updatePayment != null) {
                paymentCreateUpdateResponseDto = new PaymentCreateUpdateResponseDto(updatePayment,true, "Data Updated Successfully");
                return ResponseEntity.badRequest().body(paymentCreateUpdateResponseDto);
			}

			paymentCreateUpdateResponseDto = new PaymentCreateUpdateResponseDto(null,false, "Something wrong ! Please check all input field");
            
            return ResponseEntity.badRequest().body(paymentCreateUpdateResponseDto);

		}catch(Exception e) {

			paymentCreateUpdateResponseDto = new PaymentCreateUpdateResponseDto(null,false, "Something wrong ! Please check all input field");
			
            return ResponseEntity.badRequest().body(paymentCreateUpdateResponseDto);
		}
        
    }


    @DeleteMapping(value="/payments/{Id}")
	@JsonIgnore
	public ResponseEntity<?> deletePaymentType(@PathVariable("Id") Long Id)
	{
		  PaymentCustomResponseDto  paymentCustomResponseDto;
		try {
			PaymentType deletePayment = paymentTypeService.deletePaymentType(Id);
			if (deletePayment != null) {
				paymentCustomResponseDto = new PaymentCustomResponseDto( true, "Data Deleted Successfully");
				
                return ResponseEntity.ok().body(paymentCustomResponseDto);
			}

			paymentCustomResponseDto = new PaymentCustomResponseDto(false, "Data Not Found");
           
            return ResponseEntity.badRequest().body(paymentCustomResponseDto);

		}catch(Exception e) {

			paymentCustomResponseDto = new PaymentCustomResponseDto(false, "Failed to Deleted Data");

			return ResponseEntity.badRequest().body(paymentCustomResponseDto);
		}
	}

  
    
}
