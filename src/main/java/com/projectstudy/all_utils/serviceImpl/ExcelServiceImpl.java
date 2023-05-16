package com.projectstudy.all_utils.serviceImpl;

import com.projectstudy.all_utils.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Service
public class ExcelServiceImpl implements ExcelService {

    ResourceLoader resourceLoader;

    @Autowired
    public ExcelServiceImpl (ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public ResponseEntity<Resource> excelTemplateFileDown(String filePath, String fileName) {

        try {
            Resource resource = resourceLoader.getResource(filePath + fileName);
            File file = resource.getFile();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, file.getName())
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
