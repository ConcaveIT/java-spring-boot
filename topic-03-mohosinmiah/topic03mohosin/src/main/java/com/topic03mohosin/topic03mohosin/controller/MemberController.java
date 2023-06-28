package com.topic03mohosin.topic03mohosin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.topic03mohosin.topic03mohosin.dto.CostItemResponse;
import com.topic03mohosin.topic03mohosin.dto.JWTAuthResponse;
import com.topic03mohosin.topic03mohosin.dto.LoginDTO;
import com.topic03mohosin.topic03mohosin.dto.MemberDto;
import com.topic03mohosin.topic03mohosin.dto.ProjectDto;
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

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllCostItems() {
        List<MemberDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable Long id) {
        MemberDto member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }


    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateProject( @PathVariable Long id, @RequestBody MemberDto memberDto )
    {
        MemberDto updatedMember = memberService.updateProject(id, memberDto);
        return ResponseEntity.ok(updatedMember);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id)
    {
        return ResponseEntity.ok(memberService.deleteMember(id));
    }

}