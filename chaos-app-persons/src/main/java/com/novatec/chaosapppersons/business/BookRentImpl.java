package com.novatec.chaosapppersons.business;

import com.novatec.chaosapppersons.entities.Book;
import com.novatec.chaosapppersons.interfaces.IBookRent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Implements the IBookRent interface by implementing its methods.
 * @author: dke
 */
public class BookRentImpl implements IBookRent {

    private RestTemplate restTemplate;
    private String checkBookAvailabilityUrl = "http://localhost:8080/inventory";

    @Override
    public ResponseEntity<Book> checkBookAvailability(Book book) {

        return null;
    }

    public ResponseEntity<Book> checkBooksAvailability() {
        restTemplate = new RestTemplate();

        ResponseEntity<Book> response = restTemplate.getForEntity(checkBookAvailabilityUrl, Book.class);
        return response;
    }

    @Override
    public boolean rentBook(Book book, int rentingTime) {
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        return false;
    }
}
