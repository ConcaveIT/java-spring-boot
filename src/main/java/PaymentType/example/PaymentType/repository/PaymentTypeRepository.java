package paymentType.example.paymentType.repository;

import paymentType.example.paymentType.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
