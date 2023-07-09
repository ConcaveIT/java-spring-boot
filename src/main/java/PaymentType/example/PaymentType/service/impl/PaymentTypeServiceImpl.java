package paymentType.example.paymentType.service.impl;

import paymentType.example.paymentType.exception.PaymentTypeNotFoundException;
import paymentType.example.paymentType.service.PaymentTypeService;
import paymentType.example.paymentType.dto.PaymentTypeDto;
import paymentType.example.paymentType.entity.PaymentType;
import paymentType.example.paymentType.repository.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {


    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }
    @Override
    public PaymentTypeDto create(PaymentTypeDto paymentTypeDto) {
        PaymentType PaymentType1 = mapToEntity(paymentTypeDto);
        PaymentType PaymentType2 = paymentTypeRepository.save(PaymentType1);
        return mapToDto(PaymentType2);


    }

    @Override
    public PaymentTypeDto update(PaymentTypeDto paymentTypeDto, long id) {
        PaymentType PaymentType = paymentTypeRepository.findById(id).orElseThrow();

        PaymentType.setName(paymentTypeDto.getName());
        PaymentType.setDescription(paymentTypeDto.getDescription());
        PaymentType.setStatus(paymentTypeDto.getStatus());
        PaymentType updatedPaymentType = paymentTypeRepository.save(PaymentType);
        return mapToDto(updatedPaymentType);

    }

    @Override
    public List<PaymentTypeDto> getList() {
        List<PaymentType> PaymentTypes = paymentTypeRepository.findAll();
        return PaymentTypes.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PaymentTypeDto getById(long id) throws PaymentTypeNotFoundException {
        PaymentType PaymentType = paymentTypeRepository.findById(id).orElseThrow(()-> new PaymentTypeNotFoundException("PaymentType not found with id: " + id));
        return mapToDto(PaymentType);
    }

    @Override
    public void deleteById(long id) throws PaymentTypeNotFoundException {
        PaymentType PaymentType = paymentTypeRepository.findById(id).orElseThrow(()-> new PaymentTypeNotFoundException("PaymentType not found with id: " + id));
        paymentTypeRepository.delete(PaymentType);
    }

    private PaymentTypeDto mapToDto(PaymentType PaymentType) {
        PaymentTypeDto paymentTypeDto = new PaymentTypeDto();
        paymentTypeDto.setId(PaymentType.getId());
        paymentTypeDto.setName(PaymentType.getName());
        paymentTypeDto.setDescription(PaymentType.getDescription());
        paymentTypeDto.setStatus(PaymentType.getStatus());
        return paymentTypeDto;
    }
    private PaymentType mapToEntity(PaymentTypeDto paymentTypeDto) {
        PaymentType PaymentType = new PaymentType();
        PaymentType.setId(paymentTypeDto.getId());
        PaymentType.setName(paymentTypeDto.getName());
        PaymentType.setDescription(paymentTypeDto.getDescription());
        PaymentType.setStatus(paymentTypeDto.getStatus());

        return PaymentType;
    }

}
