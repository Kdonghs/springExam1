package com.example.springexam1.repository;

import com.example.springexam1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface springDataJpaMemberRepository extends JpaRepository<Member,Long>,memberRepository {

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
