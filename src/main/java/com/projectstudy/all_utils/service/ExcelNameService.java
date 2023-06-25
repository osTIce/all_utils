package com.projectstudy.all_utils.service;

import com.projectstudy.all_utils.repository.ExcelNameRepository;
import com.projectstudy.all_utils.serviceImpl.ExcelReadDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ExcelNameService {
    private final ExcelNameRepository excelNameRepository;

    public ExcelNameService(ExcelNameRepository excelNameRepository) {
        this.excelNameRepository = excelNameRepository;
    }

    public void ExcelNameSave(ExcelReadDTO excelReadDTO){
        excelNameRepository.save(excelReadDTO);
    }

    public void ExcelNameRemove(String ip){
        excelNameRepository.ExcelNameRemove(ip);
    }

}