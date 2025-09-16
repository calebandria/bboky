package com.bookrental.bboky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookrental.bboky.dto.LoginDto;
import com.bookrental.bboky.dto.UserDto;
//import com.bookrental.bboky.model.User;
import com.bookrental.bboky.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthPageController {
    @Autowired
    private UserService userService;

    public AuthPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        UserDto user = new UserDto();

        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        LoginDto user = new LoginDto();

        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/api/simple/new")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        if(result.hasErrors()){
            return "register";
        }
        userService.saveSimpleUser(userDto);
        return "redirect:/login";
    }



}
