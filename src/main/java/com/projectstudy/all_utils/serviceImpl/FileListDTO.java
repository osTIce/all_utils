package com.projectstudy.all_utils.serviceImpl;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@SequenceGenerator(
        name = "FILE_LIST_SEQ_GENERATOR"
        , sequenceName = "FILE_LIST_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name="FILELIST")
public class FileListDTO {

    // 시리얼 넘버
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "FILE_LIST_SEQ_GENERATOR")
    @Column(name="SN")
    private Long sn = null;

    // 사용자 IP
    @Column(name="IP")
    private String ip = null;

    // 업로드 날짜
    @CreationTimestamp
    @Column(name="UPLOAD_DATE")
    private Timestamp upload_date = null;

    // 변경하는 파일 이름
    @Column(name="FILE_NAME")
    private String fileName = null;

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

    public Timestamp getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Timestamp upload_date) {
        this.upload_date = upload_date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileListDTO{" +
                "sn=" + sn +
                ", ip='" + ip + '\'' +
                ", upload_date=" + upload_date +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
