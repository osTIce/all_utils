package com.projectstudy.all_utils.repository;

import com.projectstudy.all_utils.serviceImpl.ExcelReadDTO;
import com.projectstudy.all_utils.serviceImpl.FileListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileNameRepository extends JpaRepository<FileListDTO, Long> {

    @Query(value="DELETE FROM FILELIST fl WHERE fl.ip=:ip", nativeQuery = true)
    @Modifying
    void fileNameRemove(@Param("ip") String ip);

    @Query(value="SELECT * FROM FILELIST fl WHERE fl.ip=:ip", nativeQuery = true)
    @Modifying
    List<FileListDTO> fileNameSelect(@Param("ip") String ip);
}
