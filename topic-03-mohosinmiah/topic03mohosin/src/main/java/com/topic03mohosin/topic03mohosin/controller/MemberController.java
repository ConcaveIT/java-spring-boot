package com.topic03mohosin.topic03mohosin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.topic03mohosin.topic03mohosin.dto.JWTAuthResponse;
import com.topic03mohosin.topic03mohosin.dto.LoginDTO;
import com.topic03mohosin.topic03mohosin.dto.MemberDto;
import com.topic03mohosin.topic03mohosin.service.MemberService;



@RestController
@RequestMapping("/members")
public class MemberController {
    
    @Autowired
    private MemberService memberService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<MemberDto> createMember( @RequestBody MemberDto memberDto){

        MemberDto response = memberService.createMember(memberDto);

        return ResponseEntity.ok(response);
    }

}