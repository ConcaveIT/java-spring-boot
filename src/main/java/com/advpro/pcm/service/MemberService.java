package com.advpro.pcm.service;

import com.advpro.pcm.model.Member;
import com.advpro.pcm.dto.MemberDto;

import java.util.List;

public interface MemberService {

    public Member store(MemberDto memberDto);

    public Member update(Integer id, MemberDto memberDto);

    public String destroy(Integer id);

    public Member show(Integer id);
    
    public List<Member> getAll();

}