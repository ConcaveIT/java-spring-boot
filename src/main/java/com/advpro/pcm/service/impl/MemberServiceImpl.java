package com.advpro.pcm.service.impl;

import com.advpro.pcm.model.Member;
import com.advpro.pcm.dto.MemberDto;
import com.advpro.pcm.repository.MemberRepository;
import com.advpro.pcm.service.MemberService;
import com.advpro.pcm.dto.validator.DtoValidator;
import com.advpro.pcm.exception.DtoValidationException;
import com.advpro.pcm.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;
    DtoValidator<MemberDto> memberValidator;

    public MemberServiceImpl(MemberRepository memberRepository, DtoValidator<MemberDto> memberValidator) {
        this.memberRepository = memberRepository;
        this.memberValidator = memberValidator;
    }

    @Override
    public Member store(MemberDto memberDto) {
        var validationErrors = memberValidator.validate(memberDto);

        if (!validationErrors.isEmpty())
            throw new DtoValidationException(validationErrors);

        Member member = Member.build(
            0,
            memberDto.getName(),
            memberDto.getRole(),
            memberDto.getEmail(),
            memberDto.getPassword(),
            memberDto.getDepartment(),
            memberDto.getStatus(),
            memberDto.getCreatedAt(),
            memberDto.getUpdatedAt(),
            memberDto.getDeletedAt()
        );

        member = memberRepository.save(member);

        return member;
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
