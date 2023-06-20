package com.projectstudy.all_utils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 홈으로 이동 메서드
     * return: String
     * date: 2023-05-13
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
