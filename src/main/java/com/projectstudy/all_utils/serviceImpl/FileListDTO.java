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
    private Timestamp uploadDate = null;

    // 변경하는 파일 이름
    @Column(name="FILE_NAME")
    private String fileName = null;

    // 변경 후 파일 이름
    @Column(name="NEW_FILE_NAME")
    private String newFileName = null;

    // 파일 이름 수정 날짜
    @Column(name="UPDATE_DATE")
    private Timestamp updateDate = null;

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
        return uploadDate;
    }

    public void setUpload_date(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdate_date(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "FileListDTO{" +
                "sn=" + sn +
                ", ip='" + ip + '\'' +
                ", uploadDate=" + uploadDate +
                ", fileName='" + fileName + '\'' +
                ", newFileName='" + newFileName + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
