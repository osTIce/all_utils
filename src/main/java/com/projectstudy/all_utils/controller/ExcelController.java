package com.projectstudy.all_utils.controller;

import com.projectstudy.all_utils.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/excel/excelToFileName")
    public String ExcelToFolderName(){
        return "/excel/excelToFileName";
    }

    @GetMapping("/excel/excelFormDown")
    public ResponseEntity<Resource> excelFormDown(){
        logger.info("excelFormDown method run");

        ResponseEntity<Resource> excelFile = excelService.excelTemplateFileDown("classpath:/static/excel/", "ExcelTemplate.xlsx");

        return excelFile;
    }
}
