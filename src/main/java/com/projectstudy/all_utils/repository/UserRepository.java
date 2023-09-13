package com.projectstudy.all_utils.repository;

import com.projectstudy.all_utils.serviceImpl.UserDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

    @Query(value="SELECT * FROM USERLIST ul WHERE ul.user_id=:userId", nativeQuery = true)
    @Modifying
    List<UserDTO> joinUserIdCheck(@Param("userId") String userId);

}
