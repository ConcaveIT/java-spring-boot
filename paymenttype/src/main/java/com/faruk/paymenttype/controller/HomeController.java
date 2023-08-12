package com.faruk.paymenttype.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faruk.paymenttype.dto.UserDto;
import com.faruk.paymenttype.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/api/v1/home")
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser()
    {
        List<UserDto> users = userService.getUsers();
        if(users.size() > 0){
            return  ResponseEntity.ok().body(users);
        }
        else{
            return ResponseEntity.badRequest().body("data not found");
        }
       
    }



    @GetMapping("/current-user")
    public String getCurrentUser(Principal principal)
    {
        return principal.getName();
    }
}

