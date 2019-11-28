package com.lt.controller;

import com.lt.model.Book;
import com.lt.service.SaveBookTransactionService;
import com.lt.service.SaveTransactionDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    @Autowired(required = true)
    private SaveTransactionDemoService saveTransactionDemoService;
    @Autowired
    private SaveBookTransactionService saveBookTransactionService;

    @GetMapping("/demo")
    public List<Book> demoController() {
        List<Book> bookList = saveTransactionDemoService.list();
        return bookList;
    }

    @RequestMapping(value = "/newBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object newBook(@RequestParam String saveMode) {
        if (saveMode.equals("flush"))
            saveTransactionDemoService.saveWithFlush();
        else if (saveMode.equals("without"))
            saveTransactionDemoService.saveWithOutTransaction();
        else if (saveMode.equals("annotation"))
            saveTransactionDemoService.saveWithTransactionalAnnotation();
        else
            return "Incorrect Parameter";
        return new StringObject("Saved");
    }

    @PostMapping(value = "/saveBook")
    public Object saveBook(@RequestBody Book book) {
            saveBookTransactionService.saveBook(book);
        System.out.println("Book=[" + book + "]");
        return book;
    }
}
