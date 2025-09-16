package com.bookrental.bboky.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookrental.bboky.dto.UserDto;
import com.bookrental.bboky.model.Role;
import com.bookrental.bboky.model.User;
import com.bookrental.bboky.repository.UserRepository;
import com.bookrental.bboky.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDto> findAllUserDto() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole().toString());

        return userDto;
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = mapToUser(userDto);
        user.setDateAdhesion(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User saveSimpleUser(UserDto userDto) {
        User user = mapToUserSimple(userDto);
        user.setDateAdhesion(LocalDateTime.now());
        return userRepository.save(user);
    }

    private User mapToUser(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setRole(Role.valueOf(userDto.getRole()));

        return user;
    }

    private User mapToUserSimple(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setRole(Role.valueOf("USER"));

        return user;
    }

    @Override
    public UserDto findUserById(String idUser) {
        User user = userRepository.findById(idUser).get();
        return mapToUserDto(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String idUser) {
        userRepository.deleteById(idUser);
    }
}
