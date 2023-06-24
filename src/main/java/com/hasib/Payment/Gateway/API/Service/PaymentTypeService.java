package com.hasib.Payment.Gateway.API.Service;

import org.springframework.stereotype.Service;

import com.hasib.Payment.Gateway.API.Dto.PaymentTypeRequestDto;
import com.hasib.Payment.Gateway.API.Entity.PaymentType;
import com.hasib.Payment.Gateway.API.Repository.PaymentRepository;

@Service
public class PaymentTypeService {
    private PaymentRepository paymentRepository;

    public PaymentTypeService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // private PaymentType saveToDatabase(PaymentTypeRequestDto paymentTypeRequestDto) {
    //     PaymentType paymentType = new PaymentType();
    //     paymentType.setName(paymentTypeRequestDto.getName());
    //     paymentType.setDescription(paymentTypeRequestDto.getDescription());

    //     return paymentType;
    // }

    public PaymentTypeRequestDto createPaymentType(PaymentTypeRequestDto paymentTypeRequestDto) {
        PaymentType paymentType = new PaymentType();
        paymentType.setName(paymentTypeRequestDto.getName());
        paymentType.setDescription(paymentTypeRequestDto.getDescription());
        PaymentType paymentTypes = paymentRepository.save(paymentType);

        PaymentTypeRequestDto paymentTypeRequestDtos = new PaymentTypeRequestDto();
        paymentTypeRequestDtos.setId(paymentTypes.getId());
        paymentTypeRequestDtos.setName(paymentTypes.getName());
        paymentTypeRequestDtos.setDescription(paymentTypes.getDescription());

        return paymentTypeRequestDtos;
    }
}
