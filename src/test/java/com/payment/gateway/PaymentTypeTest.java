package com.payment.gateway;

import com.payment.gateway.entity.PaymentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentTypeTest {

    @Test
    public void testPaymentTypeCreation() {
        // Create a PaymentType
        PaymentType paymentType = new PaymentType();

        // Verify the properties
        Assertions.assertEquals(1L, paymentType.getId());
        Assertions.assertEquals("Credit Card", paymentType.getName());
        Assertions.assertEquals("Credit Card Payment", paymentType.getDescription());
    }

    @Test
    public void testPaymentTypeSetters() {
        // Create a PaymentType
        PaymentType paymentType = new PaymentType();

        // Set the properties
        paymentType.setId(1L);
        paymentType.setName("Credit Card");
        paymentType.setDescription("Credit Card Payment");

        // Verify the properties
        Assertions.assertEquals(1L, paymentType.getId());
        Assertions.assertEquals("Credit Card", paymentType.getName());
        Assertions.assertEquals("Credit Card Payment", paymentType.getDescription());
    }
}
