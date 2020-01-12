package de.novatec.patc.chaosapp.repositories;

import de.novatec.patc.chaosapp.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends MongoRepository<Book, String> {

    @Query(value = "isbn: ?0")
    public Book findBookByIsbn(String isbn);

    @Query(value = "title: ?0")
    public Book findBookByTitle(String title);
}
