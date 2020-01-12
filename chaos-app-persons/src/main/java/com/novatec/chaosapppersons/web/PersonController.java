package com.novatec.chaosapppersons.web;

import com.novatec.chaosapppersons.business.BookRentImpl;
import com.novatec.chaosapppersons.entities.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    BookRentImpl bookRent = new BookRentImpl();

    @RequestMapping(value = "/checkAvailableBooks/{title}", method = RequestMethod.GET)
    public ResponseEntity<Book> checkBookAvailabilityByTitle(@PathVariable String title) {
        return bookRent.checkBooksAvailability();
    }
}
