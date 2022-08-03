package com.controllers;

import com.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/add1")
    public String addBook1(String bookName, String bookAuthor, Double bookPrice, Model model) {
        System.out.println("---book add---");
        System.out.println(bookName);
        System.out.println(bookAuthor);
        System.out.println(bookPrice);
        model.addAttribute("key1", "value1");
        model.addAttribute("book", new Book(1, "java", "夏明", 9.99));
        return "tips";
    }

    @RequestMapping("/add2")
    public ModelAndView addBook2(String bookName, String bookAuthor, Double bookPrice) {
        System.out.println("---book add---");
        System.out.println(bookName);
        System.out.println(bookAuthor);
        System.out.println(bookPrice);
        ModelAndView modelAndView = new ModelAndView("/tips");
        modelAndView.addObject("key2", "value2");
        modelAndView.addObject("book", new Book(1, "python", "夏宇", 9.99));
        return modelAndView;
    }

    @RequestMapping("/list")
    public void listBook(@RequestHeader("token") String token) {
        System.out.println("---book list---");
        System.out.println(token);
    }

    @RequestMapping("/update")
    @ResponseBody
    public List<Book> updateBook() {
        System.out.println("---book list---");

        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "java", "夏明", 9.99));
        return books;
    }

}
