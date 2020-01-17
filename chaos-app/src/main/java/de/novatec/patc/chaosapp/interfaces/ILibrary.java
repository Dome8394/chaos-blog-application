package de.novatec.patc.chaosapp.interfaces;

import de.novatec.patc.chaosapp.entity.Book;

import java.util.List;

public interface ILibrary {

    /**
     * Returns a list of books that are currently available in
     * the library
     * @return list of books
     */
    public List<Book> getInventory();

    public Book getBookByIsbn(String isbn);
    public Book getBookByTitle(String title);
    public List<Book> getBooksByAuthor(String authorName);

    /**
     * Inserts a book into the inventory
     * @param book must not be null
     * @return book
     */
    public Book insertBook(Book book);

    /**
     * Removes a book temporarily from the inventory
     * @param book must not be null
     * @return book
     */
    public String rentBook(Book book);
}
