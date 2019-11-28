package com.lt.service;

import com.lt.model.Book;
import com.lt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SaveBookTransactionService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }
}
