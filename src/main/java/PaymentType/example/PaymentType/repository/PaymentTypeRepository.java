package PaymentType.example.PaymentType.repository;

import PaymentType.example.PaymentType.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
