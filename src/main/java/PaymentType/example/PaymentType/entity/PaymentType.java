package paymentType.example.paymentType.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_types")
public class PaymentType {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    @NotEmpty(message = "Name can't be empty")
    @NotNull(message = "Name can't be null")
    private String name;
    @Column(name = "description", nullable = false , length = 200)
    @NotEmpty(message = "Description can't be empty")
    @NotNull(message = "Description can't be null")
    private String description;
    @Column(name = "status", nullable = false, length = 1)
    private int status;

}

