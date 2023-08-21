package com.projectstudy.all_utils.repository;

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

    @Query(value="UPDATE FILELIST fl SET fl.new_file_name = :#{#fileListDTO.newFileName},fl.update_date = :#{#fileListDTO.updateDate} WHERE fl.file_name = :#{#fileListDTO.fileName} AND fl.ip = :#{#fileListDTO.ip}", nativeQuery = true)
    @Modifying
    void fileNameUpdate(@Param("fileListDTO") FileListDTO fileListDTO);
}