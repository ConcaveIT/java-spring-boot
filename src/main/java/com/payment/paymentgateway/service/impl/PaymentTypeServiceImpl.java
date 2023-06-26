package com.payment.paymentgateway.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.paymentgateway.entity.PaymentType;
import com.payment.paymentgateway.repository.PaymentTypeRepository;
import com.payment.paymentgateway.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    public ResponseEntity<List<PaymentType>> getAllPaymentType() {
		try {
			List<PaymentType> list = paymentTypeRepository.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    public ResponseEntity<PaymentType> savePaymentType(@RequestBody PaymentType paymentType){
        try {
			return new ResponseEntity<PaymentType>(paymentTypeRepository.save(paymentType),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	public ResponseEntity<PaymentType> getPaymentType(@PathVariable Long id) {
		try {
			Optional<PaymentType> paymentType = paymentTypeRepository.findById(id);

            if (paymentType.isPresent()) {
                return new ResponseEntity<>(paymentType.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<PaymentType> updatePaymentType(@PathVariable Long id, @RequestBody PaymentType updatePaymentType) {
		try {
			PaymentType paymentType = paymentTypeRepository.findById(id).get();

            paymentType.setName(updatePaymentType.getName());
            paymentType.setDescription(updatePaymentType.getDescription());
            return new ResponseEntity<PaymentType>(paymentTypeRepository.save(paymentType),HttpStatus.CREATED);            

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deletePaymentType(@PathVariable Long id) {
		try {
			Optional<PaymentType> paymentType = paymentTypeRepository.findById(id);
			if (paymentType.isPresent()) {
				paymentTypeRepository.delete(paymentType.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
            else{
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
