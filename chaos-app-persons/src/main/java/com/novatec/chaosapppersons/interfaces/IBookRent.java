package com.novatec.chaosapppersons.interfaces;

import com.novatec.chaosapppersons.entities.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookRent {

    /**
     * Checks if a single book is available in the library
     * @param book must not be null
     * @return true if book is available, else otherwise
     */
    public ResponseEntity<Book> checkBookAvailability(Book book);

    /**
     * Checks if multiple books are available in the library
     * @return list of books that are available
     */
    public ResponseEntity<Book> checkBooksAvailability();

    /**
     * Rent a book from the library for a given amount of time
     * @param book must not be null
     * @param rentingTime must not be null
     * @return true if book has been rent, false otherwise
     */
    public boolean rentBook(Book book, int rentingTime);

    /**
     * Returns a book to the library
     * @param book must not be null
     * @return true if book has been successfully returned, false otherwise
     */
    public boolean returnBook(Book book);
}
