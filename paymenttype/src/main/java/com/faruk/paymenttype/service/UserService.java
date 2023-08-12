package com.faruk.paymenttype.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faruk.paymenttype.dto.UserDto;
import com.faruk.paymenttype.entity.User;
import com.faruk.paymenttype.repository.UserRepository;

@Service
public class UserService {
   
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(UserDto::new ).collect(Collectors.toList());
	}
    
    
}
