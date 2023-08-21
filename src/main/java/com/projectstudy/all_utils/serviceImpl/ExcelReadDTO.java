package com.projectstudy.all_utils.serviceImpl;

import jakarta.persistence.*;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampService;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@SequenceGenerator(
        name = "FILE_SEQ_GENERATOR"
        , sequenceName = "FILE_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name="EXCELNAME")
public class ExcelReadDTO {

    // 파일 변경 전 이름
    @Column(name="OLDNAME")
    private String oldName = null;
    // 파일 변경 후 이름
    @Column(name="NEWNAME")
    private String newName = null;
    // 시리얼 넘버
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "FILE_SEQ_GENERATOR")
    @Column(name="SN")
    private Long sn = null;
    // 사용자 IP
    @Column(name="IP")
    private String ip = null;
    // 업로드 날짜
    @CreationTimestamp
    @Column(name="UPLOAD_DATE")
    private Timestamp uploadDate = null;

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "ExcelReadDTO{" +
                "oldName='" + oldName + '\'' +
                ", newName='" + newName + '\'' +
                ", sn=" + sn +
                ", ip='" + ip + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
