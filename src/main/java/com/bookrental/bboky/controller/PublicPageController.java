package com.bookrental.bboky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicPageController {
    
    @GetMapping("/")
    public String publicPage(Model model){
        return "homepage";
    }

}
