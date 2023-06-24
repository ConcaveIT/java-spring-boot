package com.topic02.paymentgateway.error;

public class PaymentTypeNotFoundException extends Exception {

  public PaymentTypeNotFoundException() {
  }

  public PaymentTypeNotFoundException(String arg0) {
    super(arg0);
  }

  public PaymentTypeNotFoundException(Throwable arg0) {
    super(arg0);
  }

  public PaymentTypeNotFoundException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public PaymentTypeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }

}
