package com.faruk.paymenttype.dto;


import com.faruk.paymenttype.entity.User;


public class UserDto {
    
    private Integer id;
    private String name;
    private String email;

    public UserDto(User user)
    {
        this.id       = user.getId();
        this.name     = user.getName();
        this.email    = user.getEmail();
    }


    public Integer getId()
    {
        return id;
    }

    public void setID(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

   
}
