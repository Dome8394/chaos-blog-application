package de.novatec.patc.chaosapp.web;

import de.novatec.patc.chaosapp.entity.Book;
import de.novatec.patc.chaosapp.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    /**
     * Returns a list of books that are currently available for rent.
     * @return inventory items of type Book
     */

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public @ResponseBody List<Book> getInventory() {
            return libraryService.getInventory();
    }

    /**
     * Returns a single book by its ISBN number.
     * @param isbn must not be null
     * @return single item of type Book
     */
    @RequestMapping(value = "/inventory/book/{isbn}")
    public @ResponseBody
    Book getBookByIsbn(@PathVariable String isbn) {
        return libraryService.getBookByIsbn(isbn);
    }

    /**
     * Adds a new item to the library.
     * @param book must not be null
     * @return book item
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json",
            "application/x-www-form-urlencoded"},
            produces = {"application/x-www-form-urlencoded", "application/json"})
    public String insertBookToLibrary(@RequestBody Book book) {
        return libraryService.insertBook(book);
        //return book.toString();
    }

}
