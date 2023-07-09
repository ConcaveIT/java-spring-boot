package paymentType.example.paymentType.service;

import paymentType.example.paymentType.dto.PaymentTypeDto;
import paymentType.example.paymentType.exception.PaymentTypeNotFoundException;

import java.util.List;

public interface PaymentTypeService {
    PaymentTypeDto create(PaymentTypeDto paymentTypeDto);

    PaymentTypeDto update(PaymentTypeDto paymentTypeDto, long id);

    List<PaymentTypeDto> getList();

    PaymentTypeDto getById(long id) throws PaymentTypeNotFoundException;

    void deleteById(long id) throws PaymentTypeNotFoundException;
}
