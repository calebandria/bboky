package com.bookrental.bboky.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookrental.bboky.model.Livre;
import com.bookrental.bboky.service.LivreService;

@Controller
@RequestMapping("/api/books")
public class LivreController {
  

    private final LivreService livreService;

    public LivreController(LivreService bookService) {
        this.livreService = bookService;
    }

    @GetMapping("/unavailable-by-author")
    public List<Livre> getNonAvailableBooksByAuthorAndYear(
        @RequestParam String author,
        @RequestParam int year) {
        
        return livreService.findLivreNotReturnedOfAuthorInYear(author, year);
    }
}

