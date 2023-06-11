package com.projectstudy.all_utils.controller;

import com.projectstudy.all_utils.service.ExcelService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/excel/excelToFileName")
    public String ExcelToFileName(){
        return "/excel/excelToFileName";
    }

    @PostMapping("/excel/excelToFileName")
    public void ExcelToFileName(HttpServletRequest request){

    }

    /**
     * 엑셀 서식 파일 다운로드 메서드
     * return: ResponseEntity<Resource>
     * date: 2023-05-13
     */
    @GetMapping("/excel/excelFormDown")
    public ResponseEntity<Resource> excelFormDown(){

        return excelService.excelTemplateFileDown("classpath:/static/excel/", "ExcelTemplate.xlsx");
    }
}
