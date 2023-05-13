package com.projectstudy.all_utils.serviceImpl;

import com.projectstudy.all_utils.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
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



        } catch (IOException e) {
            logger.error("no file");
        }
    }
}
