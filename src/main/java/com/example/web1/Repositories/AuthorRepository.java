package com.example.web1.Repositories;

import com.example.web1.Entities.Author;
import com.example.web1.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT * FROM web_course_database.author WHERE "
            + "MATCH (full_name) "
            + "AGAINST (?1)", nativeQuery = true)
    Set<Author> getSearchResults(String keywords);

    Author findAuthorByFullName(String fullname);

}
