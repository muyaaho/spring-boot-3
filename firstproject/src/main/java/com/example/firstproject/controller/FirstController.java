package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;

@Controller
public class FirstController {

    public String niceToMeetYou() {
        // templates 디렉토리에 작성한 mustache 페이지 파일 이름을 리턴하면 greetings.mustache 파일을 반환한다
        return "greetings";
    }
}
