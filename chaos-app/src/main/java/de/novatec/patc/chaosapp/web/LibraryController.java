package de.novatec.patc.chaosapp.web;

import de.novatec.patc.chaosapp.entity.Book;
import de.novatec.patc.chaosapp.service.LibraryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Book> getInventory() {
            return libraryService.getInventory();
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json",
            "application/x-www-form-urlencoded"}, produces = {"application/x-www-form-urlencoded", "application/json"})
    public String insertBookToLibrary(@RequestBody Book book) {
        libraryService.insertBook(book);
        return book.toString();
    }


}
