package com.hasib.Payment.Gateway.API.Service;

import org.springframework.stereotype.Service;

import com.hasib.Payment.Gateway.API.Dto.PaymentTypeRequestDto;
import com.hasib.Payment.Gateway.API.Entity.PaymentType;
import com.hasib.Payment.Gateway.API.Repository.PaymentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    public List<PaymentTypeRequestDto> getAllPaymentType() {
        List<PaymentType> paymentTypes = paymentRepository.findAll();
        List<PaymentTypeRequestDto> paymentTypeRequestDtos = paymentTypes.stream().map(paymentType -> {
            PaymentTypeRequestDto paymentTypeRequestDto = new PaymentTypeRequestDto();
            paymentTypeRequestDto.setId(paymentType.getId());
            paymentTypeRequestDto.setName(paymentType.getName());
            paymentTypeRequestDto.setDescription(paymentType.getDescription());
            return paymentTypeRequestDto;
        }).collect(Collectors.toList());
        return paymentTypeRequestDtos;
    }

    public PaymentTypeRequestDto getPaymentTypeById(Long id) {
        // PaymentType paymentType = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment Type not found"));
        // PaymentTypeRequestDto paymentTypeRequestDto = new PaymentTypeRequestDto();
        // paymentTypeRequestDto.setId(paymentType.getId());
        // paymentTypeRequestDto.setName(paymentType.getName());
        // paymentTypeRequestDto.setDescription(paymentType.getDescription());
        // return paymentTypeRequestDto;
        Optional<PaymentType> paymentType = paymentRepository.findById(id);
        if(paymentType.isPresent()) {
            PaymentType paymentDetails = paymentType.get();
            PaymentTypeRequestDto paymentTypeRequestDto = new PaymentTypeRequestDto();
            paymentTypeRequestDto.setId(paymentDetails.getId());
            paymentTypeRequestDto.setName(paymentDetails.getName());
            paymentTypeRequestDto.setDescription(paymentDetails.getDescription());
            return paymentTypeRequestDto;
        }
        else {
            return null;
        }
    }

    public PaymentTypeRequestDto updatePaymentType(Long id, PaymentTypeRequestDto paymentTypeRequestDto) {
        Optional<PaymentType> paymentType = paymentRepository.findById(id);
        if(paymentType.isPresent()) {
            PaymentType paymentDetails = paymentType.get();
            paymentDetails.setName(paymentTypeRequestDto.getName());
            paymentDetails.setDescription(paymentTypeRequestDto.getDescription());
            PaymentType updatedPaymentType = paymentRepository.save(paymentDetails);

            PaymentTypeRequestDto paymentTypeRequestDtos = new PaymentTypeRequestDto();
            paymentTypeRequestDtos.setId(updatedPaymentType.getId());
            paymentTypeRequestDtos.setName(updatedPaymentType.getName());
            paymentTypeRequestDtos.setDescription(updatedPaymentType.getDescription());
            return paymentTypeRequestDtos;
        }
        else {
            return null;
        }
    }

    public boolean deletePaymentType(Long id) {
        Optional<PaymentType> paymentType = paymentRepository.findById(id);
        if(paymentType.isPresent()) {
            paymentRepository.delete(paymentType.get());
            return true;
        }
        else {
            return false;
        }
    }
}
