package com.projectstudy.all_utils.controller;

import com.projectstudy.all_utils.service.ExcelNameService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    private ExcelNameService excelNameService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * 파일 이름 일괄 변경 페이지로 이동 메서드
     * return: String
     * date: 2023-05-13
     */
    @GetMapping("/excel/excelToFileName")
    public String ExcelToFileName(){
        return "/excel/excelToFileName";
    }

    /**
     * 엑셀 서식 파일 업로드 메서드
     * return: void
     * date: 2023-06-20
     */
    @ResponseBody
    @PostMapping("/excel/excelToFileName")
    public void ExcelToFileName(@RequestParam("fileUpload") MultipartFile file){

        List<ExcelReadDTO> fileNameList = new ArrayList<>();
        String ip = getUserIp();

        excelNameService.ExcelNameRemove(ip);

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
                    excelReadDTO.setIp(ip);

                    logger.info(excelReadDTO.getOldName());
                    logger.info(excelReadDTO.getNewName());
                    logger.info(excelReadDTO.getIp());

                    fileNameList.add(excelReadDTO);
                    excelNameService.ExcelNameSave(excelReadDTO);
                }

            } else {
                logger.error("해당 파일이 존재하지 않습니다.");
            }

        }catch (IOException e){
            logger.error("파일 읽기 오류가 발생했습니다.");
        }
    }

    /**
     * 엑셀 파일 목록 업로드 메서드
     * return: void
     * date: 2023-07-02
     */
    @ResponseBody
    @PostMapping("/excel/excelToFileList")
    public void excelToFileList(MultipartHttpServletRequest file){

        List<MultipartFile> fileList = file.getFiles("fileListUpload");
        List<String> fileNameList = new ArrayList<>();

        for(MultipartFile fileOne : fileList) {
            logger.info(fileOne.getOriginalFilename());
            fileNameList.add(fileOne.getOriginalFilename());
        }



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

    /**
     * 사용자 IP 조회 메서드
     * return: String
     * date: 2023-06-25
     */
    public String getUserIp(){

        String ip = null;
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-RealIP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
