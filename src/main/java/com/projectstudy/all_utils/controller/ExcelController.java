package com.projectstudy.all_utils.controller;

import com.projectstudy.all_utils.service.ExcelService;
import com.projectstudy.all_utils.serviceImpl.ExcelReadDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/excel/excelToFileName")
    public String ExcelToFileName(){
        return "/excel/excelToFileName";
    }

    /**
     * 엑셀 서식 파일 업로드 메서드
     * return: void
     * date: 2023-06-20
     */
    @PostMapping("/excel/excelToFileName")
    public String ExcelToFileName(@RequestParam("fileUpload") MultipartFile file, Model model){

        List<ExcelReadDTO> fileNameList = new ArrayList<>();

        try{

            Workbook workbook = null;
            workbook = new XSSFWorkbook(file.getInputStream());

            if(workbook != null) {
                Sheet sheet = workbook.getSheetAt(0);

                for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
                    Row row = sheet.getRow(i);

                    ExcelReadDTO excelReadDTO = new ExcelReadDTO();

                    excelReadDTO.setOldName(row.getCell(1).getStringCellValue());
                    excelReadDTO.setNewName(row.getCell(2).getStringCellValue());

                    logger.info(excelReadDTO.getOldName());
                    logger.info(excelReadDTO.getNewName());

                    fileNameList.add(excelReadDTO);
                }

                model.addAttribute("nameList", fileNameList);
                model.addAttribute("chk", "확인");

            } else {
                logger.error("해당 파일이 존재하지 않습니다.");
            }

        }catch (IOException e){
            logger.error("파일 읽기 오류가 발생했습니다.");
        }

        logger.info("리스트 길이 확인: " + fileNameList.size());

        return "/excel/excelToFileName";
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
