package com.projectstudy.all_utils.serviceImpl;

import com.projectstudy.all_utils.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ExcelServiceImpl implements ExcelService {

    ResourceLoader resourceLoader;

    @Autowired
    public ExcelServiceImpl (ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * 엑셀 서식 파일 다운로드 메서드
     * return: ResponseEntity<Resource>
     * date: 2023-05-13
     */
    @Override
    public ResponseEntity<Resource> excelTemplateFileDown(String filePath, String fileName) {

        try {
            Resource resource = resourceLoader.getResource(filePath + fileName);
            File file = resource.getFile();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()))
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM.toString())
                    .body(resource);

        } catch(FileNotFoundException e){
            logger.error("no file");
            return ResponseEntity.badRequest().body(null);

        } catch (IOException e) {
            logger.error("no file download");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
