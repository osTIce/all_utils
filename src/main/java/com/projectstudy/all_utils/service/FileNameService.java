package com.projectstudy.all_utils.service;

import com.projectstudy.all_utils.repository.FileNameRepository;
import com.projectstudy.all_utils.serviceImpl.FileListDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FileNameService {
    private final FileNameRepository fileNameRepository;

    public FileNameService(FileNameRepository excelNameRepository) {
        this.fileNameRepository = excelNameRepository;
    }

    public void fileNameSave(FileListDTO fileListDTO){
        fileNameRepository.save(fileListDTO);
    }

    public void fileNameRemove(String ip){
        fileNameRepository.fileNameRemove(ip);
    }

}