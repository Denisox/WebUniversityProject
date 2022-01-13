package com.example.web1.Services;

import com.example.web1.Entities.Author;
import com.example.web1.Entities.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {

    void createSingleCategoryBook(String filePathCover, String filePathContent, Long authorId, Long categoryId, String description, int pagesCount, String yearPublished, String title) throws IOException;
    void deleteBook();

    List<Book> getAllBooksFromCategory(Long id);

    Set<Book> getSearchResults(String keyword);

    void deleteSingleBook(Long id);

    void uploadBook(byte[] cover, byte[] content, Author author, String Title, String Description, String dat, String genre) throws IOException;
}
