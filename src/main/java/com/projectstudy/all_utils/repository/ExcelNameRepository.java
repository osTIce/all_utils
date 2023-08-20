package com.projectstudy.all_utils.repository;

import com.projectstudy.all_utils.serviceImpl.ExcelReadDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelNameRepository extends JpaRepository<ExcelReadDTO, Long> {

    @Query(value="DELETE FROM EXCELNAME en WHERE en.ip=:ip", nativeQuery = true)
    @Modifying
    void excelNameRemove(@Param("ip") String ip);

    @Query(value="SELECT * FROM EXCELNAME en WHERE en.ip=:ip", nativeQuery = true)
    @Modifying
    List<ExcelReadDTO> excelNameSelect(@Param("ip") String ip);
}
