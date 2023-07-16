package com.advpro.pcm.service.impl;

import com.advpro.pcm.model.Member;
import com.advpro.pcm.dto.MemberDto;
import com.advpro.pcm.repository.MemberRepository;
import com.advpro.pcm.service.MemberService;
import com.advpro.pcm.dto.validator.DtoValidator;
import com.advpro.pcm.exception.DtoValidationException;
import com.advpro.pcm.exception.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final DtoValidator<MemberDto> memberValidator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member store(MemberDto memberDto) {
        var validationErrors = memberValidator.validate(memberDto);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        var member = Member.builder()
            .name(memberDto.getName())
            .role(memberDto.getRole())
            .email(memberDto.getEmail())
            .password(passwordEncoder.encode(memberDto.getPassword()))
            .department(memberDto.getDepartment())
            .status(memberDto.getStatus())
            .createdAt(memberDto.getCreatedAt())
            .updatedAt(memberDto.getUpdatedAt())
            .deletedAt(memberDto.getDeletedAt())
            .build();

        var savedMember = memberRepository.save(member);

        return savedMember;
    }

    @Override
    public Member update(Integer id, MemberDto memberDto) {
        if(memberRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        var validationErrors = memberValidator.validate(memberDto);
        
        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        Member member = memberRepository.findById(id).get();
        member.setName(memberDto.getName());
        member.setRole(memberDto.getRole());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        member.setDepartment(memberDto.getDepartment());
        member.setStatus(memberDto.getStatus());
        member.setCreatedAt(memberDto.getCreatedAt());
        member.setUpdatedAt(memberDto.getUpdatedAt());
        member.setDeletedAt(memberDto.getDeletedAt());
        memberRepository.save(member);

        return member;
    }

    @Override
    public String destroy(Integer id) {
        memberRepository.deleteById(id);

        return "Deleted Successfully!";
    }

    @Override
    public Member show(Integer id) {
        if(memberRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("The specific record does not exist!");

        return memberRepository.findById(id).get();
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }
    
}
