package com.example.springexam1.service;

import com.example.springexam1.domain.Member;
import com.example.springexam1.repository.memberRepository;

import java.util.List;
import java.util.Optional;

public class memberService {
    private final memberRepository memberRepository;

    public memberService(memberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

//    회원가입
    public Long join(Member member){
//        같은 이름은 불가
        extracted(member);//중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void extracted(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
