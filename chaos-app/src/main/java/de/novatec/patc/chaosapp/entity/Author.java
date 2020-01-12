package de.novatec.patc.chaosapp.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Author {

    @MongoId
    private String _id;
    private String name;
    private List<Book> books;
    private String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author(String name, List<Book> books, String publisher) {
        this.name = name;
        this.books = books;
        this.publisher = publisher;
    }


}
