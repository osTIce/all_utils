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

    // 사용자 상태
    @Column(name="USER_STAT")
    private String userStat = null;

    // 사용자 상태 수정 일자
    @Column(name="USER_STAT_UPDATE_DATE")
    private Timestamp userStatUpdateDate = null;

    // 사용자 최근 접속 일자
    @Column(name="USER_LAST_CONNECT_DATE")
    private Timestamp userLastConnectDate = null;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public Timestamp getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(Timestamp userJoinDate) {
        this.userJoinDate = userJoinDate;
    }

    public String getUserStat() {
        return userStat;
    }

    public void setUserStat(String userStat) {
        this.userStat = userStat;
    }

    public Timestamp getUserStatUpdateDate() {
        return userStatUpdateDate;
    }

    public void setUserStatUpdateDate(Timestamp userStatUpdateDate) {
        this.userStatUpdateDate = userStatUpdateDate;
    }

    public Timestamp getUserLastConnectDate() {
        return userLastConnectDate;
    }

    public void setUserLastConnectDate(Timestamp userLastConnectDate) {
        this.userLastConnectDate = userLastConnectDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userJoinDate=" + userJoinDate +
                ", userStat='" + userStat + '\'' +
                ", userStatUpdateDate=" + userStatUpdateDate +
                ", userLastConnectDate=" + userLastConnectDate +
                '}';
    }
}
