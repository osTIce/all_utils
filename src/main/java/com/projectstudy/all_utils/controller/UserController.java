package com.projectstudy.all_utils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * 로그인 페이지로 이동 메서드
     * return: String
     * date: 2023-09-07
     */
    @GetMapping("/usr/login")
    public String login(){
        return "login";
    }

}
