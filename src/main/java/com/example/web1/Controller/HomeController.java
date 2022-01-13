package com.example.web1.Controller;

import com.example.web1.BindingModels.BookBindingModel;
import com.example.web1.Entities.Author;
import com.example.web1.Entities.Book;
import com.example.web1.Entities.Category;
import com.example.web1.Repositories.AuthorRepository;
import com.example.web1.Repositories.BookRepository;
import com.example.web1.Repositories.CategoryRepository;
import com.example.web1.Services.BookService;
import com.example.web1.Services.CategoryService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorRepository authorRepository;

    public HomeController(BookRepository bookRepository, CategoryRepository categoryRepository, BookService bookService, CategoryService categoryService, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorRepository = authorRepository;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<Category> categories = categoryRepository.findAllOrderByCategoryName();

        model.addAttribute("categories", categories);
        return "home/index";
    }


    @GetMapping("/category/{id}")
    public String listCategories(Model model, @PathVariable Long id) {
        if (!this.categoryRepository.existsById(id)) {
            return "redirect:/";
        }
        Category category = this.categoryRepository.findById(id).orElse(null);
        List<Category> categories = categoryService.getAllCategoriesExcept(id);
        List<Book> books = bookService.getAllBooksFromCategory(id);
        model.addAttribute("books", books);
        model.addAttribute("category", category);
        model.addAttribute("categories", categories);
        return "home/listing";
    }

    @GetMapping("/search")
    public String search(@Param("keyword") String keyword, Model model) {
        Set<Book> books = bookService.getSearchResults(keyword);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("books", books);
        return "search_result";
    }

    @GetMapping("/download/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws Exception {
        Optional<Book> result = bookRepository.findById(id);
        if (!result.isPresent()) {
            throw new Exception("Book with the ID " + id + " cannot be found!");
        }
        Book book = result.get();
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename =" + book.getTitle() + ".pdf";

        response.setHeader(headerKey, headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        outputStream.write(book.getContent());
        outputStream.close();

    }

    @GetMapping("/upload-book")
    public String uploadBook(){
        return "/upload_form";
    }

    @PostMapping( value = "/upload")
    public String submit(
            @RequestParam("file-upload") MultipartFile file, @RequestParam("fname") String title,
            @RequestParam("author") String authorName, @RequestParam("trip-start") String date,
            @RequestParam("cover-upload") MultipartFile cover, @RequestParam("resume") String description,
            @RequestParam("genre") String genre, RedirectAttributes messages) throws IOException {

        if(bookRepository.findBookByTitle(title)!=null){
            messages.addFlashAttribute("messageFail", "Upload has failed, title is already in the database!");
            return "redirect:/upload-book";
        }

        try{
            int year = Integer.parseInt(date);
            if(year<0){
                messages.addFlashAttribute("messageFail", "Upload has failed, year is not in the right format!");
                return "redirect:/upload-book";
            }
        }
        catch (Exception e){
            messages.addFlashAttribute("messageFail", "Upload has failed, year is not a number!");
            return "redirect:/upload-book";
        }

        String contentExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String coverExtension = FilenameUtils.getExtension(cover.getOriginalFilename());

        boolean coverCheck1 = !coverExtension.toString().equals("jpg");
        boolean coverCheck2 = !coverExtension.toString().equals("png");
        boolean coverCheck3 = !coverExtension.toString().equals("jpeg");
        boolean coverCheck = coverCheck1&&coverCheck2&&coverCheck3;
        if(coverCheck==true){
            messages.addFlashAttribute("messageFail", "Upload has failed, cover file not accepted!");
            return "redirect:/upload-book";
        }

        if(!contentExtension.equals("pdf")){
            messages.addFlashAttribute("messageFail", "Upload has failed, content file not accepted!");
            return "redirect:/upload-book";
        }

        if(authorRepository.findAuthorByFullName(authorName)==null){
            Author author = new Author();
            author.setFullName(authorName);
            authorRepository.save(author);
        }

        if(categoryRepository.findCategoryByCategoryName(genre)==null){
            Category category = new Category();
            category.setCategoryName(genre);
            categoryRepository.save(category);
        }

        Author author = authorRepository.findAuthorByFullName(authorName);

        byte[] content = file.getBytes();
        byte[] coverImage = cover.getBytes();

        bookService.uploadBook(coverImage, content, author, title, description ,date, genre);
        messages.addFlashAttribute("messageSuccess", "Upload has finished, book has been uploaded to the database!");
        return "redirect:/upload-book";
    }

    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable Long id, Model model){
        Book book = bookRepository.getById(id);
        book.setCoverBase64("data:image/png;base64," + Base64.getEncoder().encodeToString(book.getCover()));
        model.addAttribute("book", bookRepository.getById(id));
        return "/details";
    }

}

