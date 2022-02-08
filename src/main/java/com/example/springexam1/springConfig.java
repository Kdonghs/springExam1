package com.example.springexam1;

import com.example.springexam1.AOP.timeTraceAop;
import com.example.springexam1.repository.*;
import com.example.springexam1.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {
    private final memberRepository memberRepository;

    public springConfig(memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*private EntityManager em;

    @Autowired
    public springConfig(EntityManager em) {
        this.em = em;
    }*/

    /*private DataSource dataSource;

    @Autowired
    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public memberService memberService(){
        return new memberService(memberRepository);
    }

    /*@Bean//함수 실행시간 AOP
    public timeTraceAop timeTraceAop(){
        return new timeTraceAop();
    }*/

    /*@Bean
    public memberRepository memberRepository(){
        //스프링 빈으로 등록했을 시 함수 이름만 바뀌면 된다.
        //return new memoryMemberRepository();
        //return new jdbcMemberRepository(dataSource);
        //return new jdbcTemplateMemberRepository(dataSource);
        return new jpaMemberRepository(em);
    }*/
}
