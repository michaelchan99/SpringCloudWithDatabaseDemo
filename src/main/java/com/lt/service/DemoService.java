package com.lt.service;

import com.lt.model.Book;
import com.lt.model.BookStore;
import com.lt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    @Autowired(required = true)
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public void save() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setName("Ants Book");
        bookList.add(book);

        BookStore bookStore = new BookStore();
        bookStore.setName("Funny book store");
        bookStore.setBookList(bookList);

        book.setBookStore(bookStore);
        bookRepository.save(book);
    }
}
