package com.lt.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<BookStore> bookStoreList;
    // standard constructors

    // standard getters and setters
}