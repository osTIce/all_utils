package com.projectstudy.all_utils.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ExcelService {

    /**
     * 엑셀 서식 파일 다운로드 메서드
     * return: void
     * date: 2023-05-13
     */
    public ResponseEntity<Resource> excelTemplateFileDown(String filePath, String fileName);
}
