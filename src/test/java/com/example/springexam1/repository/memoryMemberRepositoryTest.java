package com.example.springexam1.repository;

import com.example.springexam1.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class memoryMemberRepositoryTest {
    memoryMemberRepository repository = new memoryMemberRepository();

    @AfterEach
    public void aftereach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring!!!");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(result,member);
        //org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertEquals(member1,result);
    }

    @Test
    public void findAll(){
        Member member3 = new Member();
        member3.setName("spring1");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("spring2");
        repository.save(member4);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(),2);
    }
}
