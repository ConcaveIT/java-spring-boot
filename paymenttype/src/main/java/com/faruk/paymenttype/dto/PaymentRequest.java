package com.faruk.paymenttype.dto;

import com.faruk.paymenttype.entity.PaymentType;


public class PaymentRequest {
  
   private Long ID;
    private String name;
    private String description;

    public PaymentRequest(PaymentType paymentType)
    {
        this.ID             = paymentType.getID();
        this.name           = paymentType.getName();
        this.description    = paymentType.getDescription();
    }


    public Long getID()
    {
        return ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

  
}


