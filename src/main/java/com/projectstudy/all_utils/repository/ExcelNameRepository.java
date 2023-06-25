package com.projectstudy.all_utils.repository;

import com.projectstudy.all_utils.serviceImpl.ExcelReadDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelNameRepository extends JpaRepository<ExcelReadDTO, Long> {

    @Query(value="DELETE FROM EXCELNAME en WHERE en.ip=:ip", nativeQuery = true)
    @Modifying
    void ExcelNameRemove(@Param("ip") String ip);

}
