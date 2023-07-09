package com.advpro.pcm.controller;

import com.advpro.pcm.model.Member;
import com.advpro.pcm.dto.MemberDto;
import com.advpro.pcm.service.MemberService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {    

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAll(){
        return ResponseEntity.ok(memberService.getAll());
    }

    @PostMapping
    public ResponseEntity<Member> store(@RequestBody MemberDto memberDto) {
        return new ResponseEntity<>(memberService.store(memberDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> show(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(memberService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(
    	@PathVariable("id") Integer id, 
    	@RequestBody MemberDto memberDto
    ) {
        return ResponseEntity.ok(memberService.update(id, memberDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable("id") Integer id){
        memberService.destroy(id);

        return new ResponseEntity<String>("The specific record is deleted!", HttpStatus.OK);
    }
    
}