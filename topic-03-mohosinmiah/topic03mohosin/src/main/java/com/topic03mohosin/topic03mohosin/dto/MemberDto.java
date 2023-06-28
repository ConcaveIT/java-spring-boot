package com.topic03mohosin.topic03mohosin.dto;

import java.util.Set;

import com.topic03mohosin.topic03mohosin.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String memberName;
    private String username;
    private String email;
    private String password;
    private String department;
    private String status;
    private Set<RoleDto> roles;
}
