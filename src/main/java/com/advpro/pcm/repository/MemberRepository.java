package com.advpro.pcm.repository;

import com.advpro.pcm.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Optional<Member> findByEmail(String email);

}