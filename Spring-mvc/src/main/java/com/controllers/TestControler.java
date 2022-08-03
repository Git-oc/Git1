package com.controllers;

import com.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestControler {

    @RequestMapping("/add")
    public String addBook(Book book) {
        System.out.println(book);
        return "tips";
    }

}
