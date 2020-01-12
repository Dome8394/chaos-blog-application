package com.novatec.chaosapppersons.entities;

public class Book {

    //private String _id;
    private String title;
    private String isbn;
    private String authors;

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

    public Book(String title, String isbn, String authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("Book[Title = %s, ISBN = '%s', Authors = '%s']",
                title, isbn, authors);
    }
}
