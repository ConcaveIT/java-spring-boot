package com.topic03mohosin.topic03mohosin.service;

import java.util.List;

import com.topic03mohosin.topic03mohosin.dto.CostItemResponse;
import com.topic03mohosin.topic03mohosin.dto.MemberDto;

public interface MemberService {
    
    MemberDto createMember(MemberDto memberDTO);

    List<MemberDto> getAllMembers();

    MemberDto getMemberById(Long id);

    MemberDto updateProject(Long id, MemberDto memberDto);

    String deleteMember(Long id);


} 
