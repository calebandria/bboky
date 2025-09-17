package com.bookrental.bboky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookrental.bboky.dto.LoginDto;
import com.bookrental.bboky.dto.UserDto;
import com.bookrental.bboky.model.User;
import com.bookrental.bboky.payload.MessageResponse;
import com.bookrental.bboky.payload.UserResponsePayload;
import com.bookrental.bboky.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/new")
    public ResponseEntity<?> registerNewUser(@RequestBody UserDto userInfo) {

        try {
            userService.saveUser(userInfo);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new UserResponsePayload(userInfo.getUsername(), "User created successfully"));
        }

        catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new MessageResponse("User already assigned to it!"));
        }
    }

    @GetMapping("/user/{username}")
    public String userProfile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);

        return "personal-page";
    }

}
