package com.projectstudy.all_utils.serviceImpl;

public class ExcelReadDTO {

    // 파일 변경 전 이름
    private String oldName = null;
    // 파일 변경 후 이름
    private String newName = null;

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
}
