package com.lt.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @ManyToOne(cascade={CascadeType.ALL})
    private BookStore bookStore;
    // standard constructors

    // standard getters and setters
}