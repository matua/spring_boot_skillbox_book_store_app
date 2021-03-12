package com.example.mybookshopapp.controllers;

import com.example.mybookshopapp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genres")
public class GenresPageController {

    private final BookService bookService;

    @Autowired
    public GenresPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/index.html")
    public String mainPage(Model model) {
        return "/genres/index";
    }
}
