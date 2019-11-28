package com.lt.service;

import com.lt.SpringCloudWithDatabaseDemo.SpringCloudWithDatabaseDemoApplication;
import com.lt.model.Book;
import com.lt.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringCloudWithDatabaseDemoApplication.class, H2JpaConfig.class})
class SaveTransactionDemoServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @org.junit.jupiter.api.Test
    void list() {
    }

    @org.junit.jupiter.api.Test
    @Transactional
    void saveWithOutTransaction() {
        Book book = new Book();
        book.setName("Test");
        Book savedBook = bookRepository.save(book);
        System.out.println(book.getId());
        Book foundEntity = bookRepository.getOne(savedBook.getId());
        assertNotNull(foundEntity);
        assertEquals(foundEntity.getName(), savedBook.getName());
    }

    @org.junit.jupiter.api.Test
    void saveWithTransactionalAnnotation() {
    }

    @org.junit.jupiter.api.Test
    void saveWithFlush() {
    }
}