package com.faruk.paymenttype.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faruk.paymenttype.dto.PaymentRequest;
import com.faruk.paymenttype.entity.PaymentType;
import com.faruk.paymenttype.repository.PaymentRepository;
import com.faruk.paymenttype.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    
   
    @Autowired
	PaymentRepository paymentRepository;

	@Override
	public List<PaymentRequest> getAllPayments() {
		List<PaymentType> paymentType = paymentRepository.findAll();
		return paymentType.stream().map(PaymentRequest::new ).collect(Collectors.toList());
	}

    @Override
	public PaymentType savePayment(PaymentType paymentType) {
		PaymentType newPayment = new PaymentType();
		newPayment.setName(paymentType.getName()); 
		newPayment.setDescription(paymentType.getDescription());
		
		paymentRepository.save(newPayment);

		return newPayment;
	}

    @Override
    public PaymentType getSinglePaymentType(Long Id)
    {
        PaymentType singlePayment = paymentRepository.findById(Id).get();
        if(singlePayment !=null) {
            
			return singlePayment;
		}

		return null;
		
    }


    @Override
	public PaymentType updatePaymentType(Long Id, PaymentType paymentType) {
        PaymentType updatePayment = paymentRepository.findById(Id).get();
		updatePayment.setName(paymentType.getName()); 
		updatePayment.setDescription(paymentType.getDescription());
		paymentRepository.save(updatePayment);

		return updatePayment;
	}


    @Override
    public PaymentType deletePaymentType(Long Id) {
		PaymentType deletePayment = paymentRepository.findById(Id).get();
		if(deletePayment !=null) {
			paymentRepository.deleteById(Id);

			return deletePayment;
		}

		return null;
	}

}
