package paymentType.example.paymentType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaymentTypeDto {
    private long id;
    @NotBlank(message = "please write name")
    private String name;
    @NotBlank(message = "please write description")
    private String description;
    private int status;
}
