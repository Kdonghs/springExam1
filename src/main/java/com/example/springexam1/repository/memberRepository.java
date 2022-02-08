package com.example.springexam1.repository;

import com.example.springexam1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface memberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
