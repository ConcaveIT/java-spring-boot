package PaymentType.example.PaymentType.service;

import PaymentType.example.PaymentType.dto.PaymentTypeDto;
import PaymentType.example.PaymentType.exception.PaymentTypeNotFoundException;

import java.util.List;

public interface PaymentTypeService {
    PaymentTypeDto create(PaymentTypeDto paymentTypeDto);

    PaymentTypeDto update(PaymentTypeDto paymentTypeDto, long id);

    List<PaymentTypeDto> getList();

    PaymentTypeDto getById(long id) throws PaymentTypeNotFoundException;

    void deleteById(long id) throws PaymentTypeNotFoundException;
}
