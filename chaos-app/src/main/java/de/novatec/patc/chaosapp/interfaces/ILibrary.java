package de.novatec.patc.chaosapp.interfaces;

import de.novatec.patc.chaosapp.entity.Book;

import java.util.List;
import java.util.Optional;

public interface ILibrary {
    public List<Book> getInventory();
    public Book getBookByIsbn(String isbn);
    public Book getBookByTitle(String title);
    public List<Book> getBooksByAuthor(String authorName);
    public String insertBook(Book book);
}
