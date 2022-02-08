package com.example.springexam1.controller;

import com.example.springexam1.domain.Member;
import com.example.springexam1.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final memberService memberService;

    /*@Autowired   실행 중간에 변경 가능해서 잘 사용 안함
    public void setMemberService(memberService memberService){
        this.memberService = memberService;
    }*/

    @Autowired
    public MemberController(memberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberFome";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberlist";
    }
}
