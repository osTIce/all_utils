package com.projectstudy.all_utils.controller;

import com.projectstudy.all_utils.service.UserService;
import com.projectstudy.all_utils.serviceImpl.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

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
    @ResponseBody
    @PostMapping("/usr/login")
    public void login(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw){

        UserController userController = new UserController();

        logger.info("사용자 아이디: " + userId);
        logger.info("사용자 비밀번호: " + userPw);

        String salt = userController.getSalt();
        logger.info("Salt 값 확인: " + salt);

        String encryptPassword = userController.getEncrypt(userPw, salt);
        logger.info("암호화된 비밀번호 값 확인: " + encryptPassword);
    }

    /**
     * 암호화 생성 메서드
     * return: String
     * date: 2023-09-10
     */
    public String getEncrypt(String pwd,String salt) {

        String result = "";

        try{

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update((pwd+salt).getBytes());
            byte[] passwordSalt = md.digest();

            StringBuffer sb = new StringBuffer();
            for(byte passwordRandom : passwordSalt){
                sb.append(String.format("%02x", passwordRandom));
            }

            result = sb.toString();

        }catch(NoSuchAlgorithmException e){
            System.out.println("암호화 진행중 오류 발생");
        }

        return result;

    }

    /**
     * Salt 생성 메서드
     * return: String
     * date: 2023-09-10
     */
    public String getSalt(){
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[20];

        sr.nextBytes(salt);

        StringBuffer sb = new StringBuffer();

        for(byte randomSalt : salt){
            sb.append(String.format("%02x", randomSalt));
        };

        return sb.toString();
    }

    /**
     * 회원가입 페이지로 이동 메서드
     * return: String
     * date: 2023-09-11
     */
    @GetMapping("/usr/join")
    public String join(){
        return "join";
    }

    @ResponseBody
    @PostMapping("/usr/joinIdCheck")
    public String joinIdCheck(@RequestParam("userId") String userId, Model model){

        String userYN = "";

        logger.info("사용자 아이디: " + userId);

        List<UserDTO> userCheck = userService.joinUserIdCheck(userId);

        logger.info("사용자 존재 유무 확인: " + userCheck);

        if(userCheck.size() == 0){
            userYN = "Yes";
            logger.info("동일한 사용자 존재하지 않음");
        } else {
            userYN = "No";
            logger.error("동일한 사용자 존재");
        }

        return userYN;
    }
}
