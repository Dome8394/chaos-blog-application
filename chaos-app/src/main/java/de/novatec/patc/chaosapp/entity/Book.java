package de.novatec.patc.chaosapp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Book {

    @MongoId
    private String _id;
    private String title;
    private String isbn;
    private String authors;
    private boolean rented;

    public boolean getRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Book() {}

    public Book(String title, String isbn, String authors, boolean rented) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.rented = rented;
    }

    @Override
    public String toString() {
        return String.format("Book[Title = %s, ISBN = '%s', Authors = '%s']",
                title, isbn, authors);
    }
}
