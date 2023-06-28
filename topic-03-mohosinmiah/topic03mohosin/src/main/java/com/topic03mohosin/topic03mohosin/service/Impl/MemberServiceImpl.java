package com.topic03mohosin.topic03mohosin.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.dto.CostItemResponse;
import com.topic03mohosin.topic03mohosin.dto.MemberDto;
import com.topic03mohosin.topic03mohosin.dto.RoleDto;
import com.topic03mohosin.topic03mohosin.entity.CostItem;
import com.topic03mohosin.topic03mohosin.entity.Project;
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
        Set<Role> roles = new HashSet<>();
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

    @Override
    public List<MemberDto> getAllMembers() {
        
        List<User> members = userRepository.findAll();
        return members.stream()
                .map(member -> modelMapper.map(member, MemberDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto getMemberById(Long id) {
        
       User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cost item not found with id: " + id)
            );
        return modelMapper.map(user,MemberDto.class);
    }

    @Override
    public MemberDto updateProject( Long id, MemberDto memberDto )
    {
        
        Optional<User> checkUser = userRepository.findById(id);
            
        if(checkUser.isPresent())
        {
            User user = checkUser.get();

            if (memberDto.getMemberName() != null && !memberDto.getMemberName().isEmpty()) {
                user.setMemberName(memberDto.getMemberName());
            }

            if (memberDto.getUsername() != null && !memberDto.getUsername().isEmpty()) {
                user.setUsername(memberDto.getUsername());
            }

            if (memberDto.getEmail() != null && !memberDto.getEmail().isEmpty()) {
                user.setEmail(memberDto.getEmail());
            }

            if (memberDto.getPassword() != null && !memberDto.getPassword().isEmpty()) {
                user.setPassword(memberDto.getPassword());
            }

            if (memberDto.getDepartment() != null && !memberDto.getDepartment().isEmpty()) {
                user.setDepartment(memberDto.getDepartment());
            }

            if (memberDto.getStatus() != null && !memberDto.getStatus().isEmpty()) {
                user.setStatus(memberDto.getStatus());
            }

            // Add existing roles to the updated roles set
            Set<Role> roles = user.getRoles();
            // Update roles if provided in memberDTO
            if (memberDto.getRoles() != null && !memberDto.getRoles().isEmpty()) {
                for (RoleDto roleDto : memberDto.getRoles()) {
                    Role role = roleRepository.findByName(roleDto.getRoleName())
                        .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleDto.getRoleName()));
                        roles.add(role);
                }
            }

            user.setRoles(roles);
        
            user.setPassword(passwordEncoder.encode(memberDto.getPassword()));
            User updateMember = userRepository.save(user);
            return modelMapper.map(updateMember, MemberDto.class);
        }
        else
        {
            throw new EntityNotFoundException("Member U=Is not found");
        }
    
    }

    @Override
    public String deleteMember(Long id)
    {
        Optional<User> getMember = userRepository.findById(id);
        if(getMember.isPresent()) {
            User member = getMember.get();

            // Delete the associated user_roles records
            member.getRoles().clear();

            // User delete
            userRepository.delete(member);

            return "User deleted : ID " + member.getId();
        }
        else
        {
            return "User not found with ID: " + id;
        }
    }





}
