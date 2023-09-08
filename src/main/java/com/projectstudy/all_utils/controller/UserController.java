package com.projectstudy.all_utils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 로그인 메서드
     * return: String
     * date: 2023-09-08
     */
    @PostMapping("usr/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw){

        System.out.println(userId);
        System.out.println(userPw);

        return "/";
    }
}
