package com.projectstudy.all_utils.repository;

import com.projectstudy.all_utils.serviceImpl.ExcelReadDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelNameRepository extends JpaRepository<ExcelReadDTO, Long> {

}
