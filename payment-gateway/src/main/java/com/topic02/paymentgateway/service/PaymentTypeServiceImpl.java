package com.topic02.paymentgateway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic02.paymentgateway.entity.PaymentType;
import com.topic02.paymentgateway.error.PaymentTypeNotFoundException;
import com.topic02.paymentgateway.repository.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

  @Autowired
  private PaymentTypeRepository paymentTypeRepository;

  @Override
  public PaymentType savePaymentType(PaymentType paymentType) {
    return paymentTypeRepository.save(paymentType);
  }

  @Override
  public List<PaymentType> fetchAllPaymentTypes() {
    List<PaymentType> allPaymentTypes = paymentTypeRepository.findAll();
    return allPaymentTypes;
  }

  @Override
  public PaymentType getPaymentTypeById(Long id) throws PaymentTypeNotFoundException {
    Optional<PaymentType> paymentType = paymentTypeRepository.findById(id);
    if (!paymentType.isPresent()) {
      throw new PaymentTypeNotFoundException("Payment Type is not available!");
    }
    return paymentType.get();
  }

  @Override
  public PaymentType updatePaymentTypeById(Long id, PaymentType paymentType) {
    Optional<PaymentType> oldPaymentType = paymentTypeRepository.findById(id);
    if (oldPaymentType.isPresent()) {
      PaymentType newPaymentType = oldPaymentType.get();
      newPaymentType.setName(paymentType.getName());
      newPaymentType.setDescription(paymentType.getDescription());
      return paymentTypeRepository.save(newPaymentType);
    }
    return null;
  }

  @Override
  public PaymentType deletePaymentTypeById(Long id) {
    Optional<PaymentType> paymentType = paymentTypeRepository.findById(id);
    if (paymentType.isPresent()) {
      paymentTypeRepository.deleteById(id);
      return paymentType.get();
    }
    return null;
  }
}
