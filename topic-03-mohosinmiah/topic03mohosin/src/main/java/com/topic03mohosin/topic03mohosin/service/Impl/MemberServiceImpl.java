package com.topic03mohosin.topic03mohosin.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.dto.MemberDto;
import com.topic03mohosin.topic03mohosin.dto.RoleDto;
import com.topic03mohosin.topic03mohosin.entity.Role;
import com.topic03mohosin.topic03mohosin.entity.User;
import com.topic03mohosin.topic03mohosin.repository.RoleRepository;
import com.topic03mohosin.topic03mohosin.repository.UserRepository;
import com.topic03mohosin.topic03mohosin.service.MemberService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MemberServiceImpl implements MemberService{

     @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public MemberDto createMember(MemberDto memberDTO) {
       
         User user = modelMapper.map(memberDTO, User.class);

        // Save the user roles
        Set<Role> roles = new HashSet<>(1);
        for (RoleDto roleDto : memberDTO.getRoles()) {
            System.out.println("************* roleDto *************************");
            System.out.println(roleDto);
            System.out.println("))))))))) memberDTO ))))))))))");
            System.out.println(memberDTO);
            Role role = roleRepository.findByName(roleDto.getRoleName())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleDto.getRoleName()));
            roles.add(role);
        }
        user.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        user.setRoles(roles);

        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, MemberDto.class);
       
    }
    
}
