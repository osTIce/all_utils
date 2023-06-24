package com.projectstudy.all_utils.serviceImpl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EXCELNAME")
public class ExcelReadDTO {

    // 파일 변경 전 이름
    @Column(name="OLDNAME")
    private String oldName = null;
    // 파일 변경 후 이름
    @Column(name="NEWNAME")
    private String newName = null;
    @Id
    @Column(name="SN")
    private String sn = null;

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "ExcelReadDTO{" +
                "oldName='" + oldName + '\'' +
                ", newName='" + newName + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }
}
