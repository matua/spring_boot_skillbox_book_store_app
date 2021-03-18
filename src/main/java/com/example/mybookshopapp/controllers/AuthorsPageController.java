package com.example.mybookshopapp.controllers;

import com.example.mybookshopapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorsPageController {

    private final BookRepository bookRepository;

    @Autowired
    public AuthorsPageController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index.html")
    public String mainPage(Model model) {
        model.addAttribute("authorsData", bookRepository.getAuthorData());
        return "/authors/index";
    }
}
