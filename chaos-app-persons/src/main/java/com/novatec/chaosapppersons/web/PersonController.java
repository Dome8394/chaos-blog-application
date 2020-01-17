package com.novatec.chaosapppersons.web;

import com.novatec.chaosapppersons.business.BookRentImpl;
import com.novatec.chaosapppersons.entities.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    BookRentImpl bookRent = new BookRentImpl();

    @RequestMapping(value = "/checkAvailableBooks/", method = RequestMethod.GET, consumes = "application/json")
    public String checkBookAvailabilityByTitle() {
        return bookRent.checkBooksAvailability();
    }

    @RequestMapping(value = "/rentBook", method = RequestMethod.POST, produces = "application/json")
    public Boolean rentBook(@RequestBody Book book) {
        return bookRent.rentBook(book);
    }
}
