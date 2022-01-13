package com.example.web1.Services.ServiceImpl;

import com.example.web1.Entities.Author;
import com.example.web1.Entities.Book;
import com.example.web1.Entities.Category;
import com.example.web1.Repositories.AuthorRepository;
import com.example.web1.Repositories.BookRepository;
import com.example.web1.Repositories.CategoryRepository;
import com.example.web1.Services.BookService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createSingleCategoryBook(String filePathCover, String filePathContent, Long authorId, Long categoryId, String description, int pagesCount, String yearPublished, String title) throws IOException {
        File file = new File(filePathCover);
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Book book = new Book();
        book.setCover(bFile);
        book.setAuthor(authorRepository.getById(authorId));
        Set<Category> categories = new HashSet<>();
        categories.add(categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException()));
        book.setCategories(categories);
        book.setDescription(description);
        book.setPagesCount(pagesCount);
        book.setTitle(title);
        File file1 = new File(filePathContent);
        byte[] bytes = Files.readAllBytes(file1.toPath());
        book.setContent(bytes);
        book.setYearPublished(yearPublished);
        book.setCoverBase64(new String(Base64.getUrlEncoder().encode(book.getCover()), "UTF-8"));
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook() {
        bookRepository.deleteAll();
    }

    @Override
    public Set<Book> getSearchResults(String keyword) {
        Set<Book> resultSet = new HashSet<>();
        authorRepository.getSearchResults(keyword).stream().forEach(author -> author.getBooks().stream().forEach(book -> resultSet.add(book)));
        bookRepository.getSearchResults(keyword).stream().forEach(book -> resultSet.add(book));
        resultSet.stream().forEach(book -> book.setCoverBase64("data:image/png;base64," + Base64.getEncoder().encodeToString(book.getCover())));
        return resultSet;
    }

    @Override
    public List<Book> getAllBooksFromCategory(Long id) {
        List<Book> books = categoryRepository.findById(id).orElseThrow(() ->new IllegalArgumentException())
                .getBooks().stream().collect(Collectors.toList());

        books.forEach(book -> book.setCoverBase64("data:image/png;base64," + Base64.getEncoder().encodeToString(book.getCover())));
        return books;


    }

    @Override
    public void uploadBook(byte[] cover, byte[] content, Author author, String title, String description, String date, String genre) throws IOException {
        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setYearPublished(date);
        book.setPagesCount(0);
        book.setContent(content);
        book.setCover(cover);
        Set<Category> categories = new HashSet<>();
        categories.add(categoryRepository.findCategoryByCategoryName(genre));
        book.setCategories(categories);
        bookRepository.save(book);

    }

    @Override
    public void deleteSingleBook(Long id) {
        bookRepository.delete(bookRepository.getById(id));
    }
}
