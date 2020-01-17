package com.novatec.chaosapppersons.business;

import com.novatec.chaosapppersons.entities.Book;
import com.novatec.chaosapppersons.interfaces.IBookRent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Implements the IBookRent interface by implementing its methods.
 * @author: dke
 */
public class BookRentImpl implements IBookRent {

    private RestTemplate restTemplate;
    private String checkBookAvailabilityUrl = "http://localhost:8080/inventory";
    private String RENT_BOOK_URL = "http://localhost:8080/add";
    private String availableBooks;

    @Override
    public ResponseEntity<Book> checkBookAvailability(Book book) {

        return null;
    }

    /**
     * Check if there are currently any books available
     * @return
     */
    public String checkBooksAvailability() {
        restTemplate = new RestTemplate();

        availableBooks = restTemplate.getForObject(checkBookAvailabilityUrl, String.class);
        return availableBooks;
    }

    @Override
    public boolean rentBook(Book book) {

        if (!(availableBooks == null)) {
            restTemplate = new RestTemplate();

            //Book requestedBook = new Book("Napoleon Hill", "12", "Think and Grow Rich");
            Book result = restTemplate.postForObject(RENT_BOOK_URL, book, Book.class);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        return false;
    }
}
