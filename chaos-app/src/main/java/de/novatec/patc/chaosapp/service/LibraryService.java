package de.novatec.patc.chaosapp.service;

import de.novatec.patc.chaosapp.entity.Book;
import de.novatec.patc.chaosapp.interfaces.ILibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryService implements ILibrary {

    /**
     * Class variables
     */
    private Book book;
    private Query query = new Query();
    private List<Book> retrievedBooks;

    private MongoTemplate mongoTemplate;

    public LibraryService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private static final Logger log = LoggerFactory.getLogger(LibraryService.class);

    @Override
    public List<Book> getInventory() {
        query.addCriteria(Criteria.where("rented").is(false));
        return mongoTemplate.find(query, Book.class);
    }

    @Override
    public Book getBookByIsbn(String isbn) {

        query.addCriteria(Criteria.where("isbn").is(isbn));
        book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    @Override
    public Book getBookByTitle(String title) {

        query.addCriteria(Criteria.where("title").is(title));
        book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {

        query.addCriteria(Criteria.where("authorName").in(authorName));
        retrievedBooks = mongoTemplate.find(query, Book.class);
        return retrievedBooks;
    }

    @Override
    public Book insertBook(Book book) {

        query.addCriteria(Criteria.where("isbn").is(book.getIsbn()));
        if (mongoTemplate.exists(query, Book.class)) {
            book = mongoTemplate.findOne(query, Book.class);
            return book;
        }

        mongoTemplate.insert(book);
        return book;
    }

    /**
     * Sets the rented status of a book to 'true'
     * @param book must not be null
     * @return updated Book
     */
    @Override
    public String rentBook(Book book) {
        query.addCriteria(Criteria.where("rented").is(false));
        query.addCriteria(Criteria.where("isbn").is(book.getIsbn()));

        Update update = new Update();
        update.set("rented", true);

        Book rentedBook = mongoTemplate.findAndModify(query, update, Book.class);
        return rentedBook.toString();
    }
}
