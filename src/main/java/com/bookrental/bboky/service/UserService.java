package com.bookrental.bboky.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookrental.bboky.dto.UserDto;
import com.bookrental.bboky.model.User;

@Service
public interface UserService {
    List<User> findAllUsers();

    List<UserDto> findAllUserDto();

    User saveUser(UserDto userDto);

    UserDto findUserById(String idUser);

    void updateUser(UserDto user);

    void deleteUser(String idUser);
    
}