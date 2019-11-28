package com.lt.service;

import com.lt.model.Book;
import com.lt.model.BookStore;
import com.lt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaveTransactionDemoService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public void saveWithOutTransaction() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setName("Ants Book");
        bookList.add(book);

        BookStore bookStore = new BookStore();
        bookStore.setName("Funny book store");
        bookStore.setBookList(bookList);
        List<BookStore> bookStoreList = new ArrayList<>();
        bookStoreList.add(bookStore);

        book.setBookStoreList(bookStoreList);
        bookRepository.save(book);

        book.setName("Ants Book 2");    // Not saved
    }

    @Transactional
    public void saveWithTransactionalAnnotation() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setName("Ants Book");
        bookList.add(book);

        BookStore bookStore = new BookStore();
        bookStore.setName("Funny book store");
        bookStore.setBookList(bookList);
        List<BookStore> bookStoreList = new ArrayList<>();
        bookStoreList.add(bookStore);

        book.setBookStoreList(bookStoreList);
        bookRepository.save(book);

        book.setName("Ants Book 2");
    }

    public void saveWithFlush() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setName("Ants Book");
        bookList.add(book);

        BookStore bookStore = new BookStore();
        bookStore.setName("Funny book store");
        bookStore.setBookList(bookList);
        List<BookStore> bookStoreList = new ArrayList<>();
        bookStoreList.add(bookStore);

        book.setBookStoreList(bookStoreList);
        bookRepository.save(book);

        book.setName("Ants Book 2");
        bookRepository.flush();
    }
}
