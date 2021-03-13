package com.example.mybookshopapp.controllers;

import com.example.mybookshopapp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String redirectToMain(Model model) {
        return "redirect:/bookshop/main";
    }

    @GetMapping("/bookshop/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookService.getBookData());
        return "index";
    }

    @GetMapping("/index.html")
    public String mainPageFromPtherPages(Model model) {
        model.addAttribute("bookData", bookService.getBookData());
        return "index";
    }
}
