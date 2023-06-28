package com.topic03mohosin.topic03mohosin.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.topic03mohosin.topic03mohosin.entity.User;
import com.topic03mohosin.topic03mohosin.repository.RoleRepository;
import com.topic03mohosin.topic03mohosin.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
       User user =  userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
            () -> new UsernameNotFoundException("User not found by username or email" + usernameOrEmail)
        );

        // Convert user roles to somple Granted Autority
        Set<GrantedAuthority> authorities = user.getRoles().stream().map(
            (role) -> new SimpleGrantedAuthority(role.getName() )).collect(Collectors.toSet()
        );

        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
    
}
