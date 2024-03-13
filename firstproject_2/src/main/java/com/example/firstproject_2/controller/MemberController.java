package com.example.firstproject_2.controller;

import com.example.firstproject_2.dto.MemberForm;
import com.example.firstproject_2.entity.Member;
import com.example.firstproject_2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String newMemberForm() {
        return "members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form) {
        System.out.println(form.toString());
        Member member = form.toEntity();
        System.out.println(member.toString());

        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }
}
