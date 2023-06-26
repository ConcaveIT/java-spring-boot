package com.advpro.payment.service.impl;

import com.advpro.payment.model.PaymentType;
import com.advpro.payment.dto.PaymentTypeDto;
import com.advpro.payment.repository.PaymentTypeRepository;
import com.advpro.payment.service.PaymentTypeService;
import com.advpro.payment.validator.DtoValidator;
import com.advpro.payment.exception.DtoValidationException;
import com.advpro.payment.exception.PaymentMethodNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    DtoValidator<PaymentTypeDto> paymentTypeValidator;
    PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository, DtoValidator<PaymentTypeDto> paymentTypeValidator) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.paymentTypeValidator = paymentTypeValidator;
    }

    @Override
    public PaymentType storePaymentType(PaymentTypeDto paymentTypeDto) {
        var validationErrors = paymentTypeValidator.validate(paymentTypeDto);
        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        PaymentType paymentType = PaymentType.build(
            0,
            paymentTypeDto.getName(),
            paymentTypeDto.getDescription(),
            paymentTypeDto.getCreatedAt(),
            paymentTypeDto.getUpdatedAt(),
            paymentTypeDto.getDeletedAt()
        );

        paymentType = paymentTypeRepository.save(paymentType);

        return paymentType;
    }

    @Override
    public PaymentType updatePaymentType(Integer id, PaymentTypeDto paymentTypeDto) {
        if(paymentTypeRepository.findById(id).isEmpty())
            throw new PaymentMethodNotFoundException("Payment type does not exist!");

        PaymentType paymentType = paymentTypeRepository.findById(id).get();
        paymentType.setName(paymentTypeDto.getName());
        paymentType.setDescription(paymentTypeDto.getDescription());
        paymentType.setCreatedAt(paymentTypeDto.getCreatedAt());
        paymentType.setUpdatedAt(paymentTypeDto.getUpdatedAt());
        paymentType.setDeletedAt(paymentTypeDto.getDeletedAt());
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
            throw new PaymentMethodNotFoundException("Payment type does not exist!");

        return paymentTypeRepository.findById(id).get();
    }

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }
    
}
