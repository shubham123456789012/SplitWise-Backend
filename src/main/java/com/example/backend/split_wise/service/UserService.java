package com.example.backend.split_wise.service;

import com.example.backend.split_wise.dao.UserDao;
import com.example.backend.split_wise.dto.UserDto;
import com.example.backend.split_wise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDto saveUser(UserDto userDto) {
        UserDao userDao = UserDao.fromUserDto(userDto);
        try {
            userDao = userRepository.save(userDao);
            userDto.setId(userDao.getId());
            return userDto;
        } catch (Exception e) {
            log.error("Error while Saving User: {}", e.getMessage());
        }
        return null;
    }

    public UserDto findUser(Long id) {
        UserDao userDao = userRepository.findById(id).orElse(null);
        if (userDao == null) {
            return null;
        }
        return UserDto.fromUserDao(userDao);
    }
}
