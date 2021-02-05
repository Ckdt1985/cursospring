package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String reference;

    // avoid this "No default constructor for entity"
    public Book() {
    }

    public Book(Long id, String name, String author, String reference) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.reference = reference;
    }

    public Book(String name, String author, String reference) {
        this.name = name;
        this.author = author;
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", reference=" + reference +
                '}';
    }

}
