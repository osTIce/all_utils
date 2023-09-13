package com.projectstudy.all_utils.service;

import com.projectstudy.all_utils.repository.UserRepository;
import com.projectstudy.all_utils.serviceImpl.UserDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> joinUserIdCheck(String userId){
        return userRepository.joinUserIdCheck(userId);
    }
}
