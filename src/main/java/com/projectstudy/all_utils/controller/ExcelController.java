package com.projectstudy.all_utils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExcelController {

    @GetMapping("/excel/excelToFileName")
    public String ExcelToFolderName(){
        return "/excel/excelToFileName";
    }
}
