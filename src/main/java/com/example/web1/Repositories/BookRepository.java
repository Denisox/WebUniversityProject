package com.example.web1.Repositories;

import com.example.web1.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM web_course_database.books WHERE "
            + "MATCH (title, description, year_published) "
            + "AGAINST (?1)", nativeQuery = true)
     Set<Book> getSearchResults(String keywords);

    Book findBookByTitle(String title);
}
