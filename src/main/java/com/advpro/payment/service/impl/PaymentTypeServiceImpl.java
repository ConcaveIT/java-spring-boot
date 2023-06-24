package com.advpro.payment.service.impl;

import com.advpro.payment.model.PaymentType;
import com.advpro.payment.repository.PaymentTypeRepository;
import com.advpro.payment.service.PaymentTypeService;
import com.advpro.payment.exception.PaymentMethodNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public PaymentType storePaymentType(PaymentType paymentType) {
        paymentTypeRepository.save(paymentType);

        return paymentType;
    }

    @Override
    public PaymentType updatePaymentType(PaymentType paymentType) {
        paymentTypeRepository.save(paymentType);

        return paymentType;
    }

    @Override
    public String deletePaymentType(Integer id) {
        paymentTypeRepository.deleteById(id);

        return "Deleted Successfully!";
    }

    @Override
    public PaymentType getPaymentType(Integer id) {
        if(paymentTypeRepository.findById(id).isEmpty())
            throw new PaymentMethodNotFoundException("Payment method does not exist!");

        return paymentTypeRepository.findById(id).get();
    }

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }
    
}
