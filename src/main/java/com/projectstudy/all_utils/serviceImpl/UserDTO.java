package com.projectstudy.all_utils.serviceImpl;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Table(name="USERLIST")
public class UserDTO {

    // 사용자 아이디
    @Id
    @Column(name="USER_ID")
    private String userId = null;

    // 사용자 비밀번호
    @Column(name="USER_PW")
    private String userPw = null;

    // 사용자 회원가입 날짜
    @Column(name="USER_JOIN_DATE")
    private Timestamp userJoinDate = null;
}
