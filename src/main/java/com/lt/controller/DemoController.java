package com.lt.controller;

import com.lt.model.Book;
import com.lt.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired(required = true)
    private DemoService demoService;

    @GetMapping("/demo")
    public List<Book> demoController() {
        List<Book> bookList = demoService.list();
        return bookList;
    }

    @GetMapping("/newBook")
    public String newBook() {
        demoService.save();
        return "Saved";
    }
}
