package com.faruk.paymenttype.dto;

import com.faruk.paymenttype.entity.PaymentType;

public class PaymentCreateUpdateResponseDto {
    
    private PaymentType paymentType;
	private boolean success;
	private String message;
	
	public PaymentCreateUpdateResponseDto(PaymentType paymentType ,boolean success, String message) {
		super();
		this.success     = success;
		this.message     = message;
		this.paymentType = paymentType;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setTodo(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
    
}

