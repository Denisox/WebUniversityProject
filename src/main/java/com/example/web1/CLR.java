package com.example.web1;

import com.example.web1.Services.AuthorService;
import com.example.web1.Services.BookService;
import com.example.web1.Services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public CLR(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {

    /*  bookService.deleteBook();

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Adventure\\cover-orig-7032.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Adventure\\Adventures-of-Huckleberry-Finn.pdf",
                1L,
                5L,
                "The drifting journey of Huck and his friend Jim, a runaway slave, down the Mississippi River on their raft may be one of the most enduring images of escape and freedom in all of American literature. Although the society it satirized was already history at the time of publication, the book was quite controversial, and has remained so to this day.",
                305,
                "1884",
                "Adventures of Huckleberry Finn");


   /*    authorService.addAuthor("Miguel de Cervantes", false);
        authorService.addAuthor("Arthur Conan Doyle", false);
        authorService.addAuthor("William Shakespeare", false);
        authorService.addAuthor("Adam Smith", false);
        authorService.addAuthor("Albert Einstein", false);
        authorService.addAuthor("Lyman Frank Baum", false);
        authorService.addAuthor("Harry Dexter Kitson", false);
        authorService.addAuthor("Jane Austen", false);
        authorService.addAuthor("Herbert George Wells", false);
        authorService.addAuthor("Howard Phillips Lovecraft", false);


        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Classics\\cover-cust-1621.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Classics\\Don-Quixote.pdf",
                2L,
                8L,
                "One of the earliest novels in a modern European language, one which many people consider the finest book in the Spanish language.",
                1280,
                "1615",
                "Don Quixote");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Criminal\\cover-cust-2292.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Criminal\\The-Hound-of-the-Baskervilles.pdf",
                3L,
                4L,
                "This may be the most popular of all of the Sherlock Holmes stories. Inspired by regional mythology of the British Isles concerning hell-hounds, the tale tells of detective Sherlock Holmes and his assistant Dr. Watson as they are called to investigate an alleged curse upon the house of the Baskervilles.",
                155,
                "1902",
                "The Hound of the Baskervilles");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Drama\\cover-cust-6331.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Drama\\The-Complete-Works-of-William-Shakespeare.pdf",
                4L,
                7L,
                "Every known work of the Bard, in one large volume.",
                4024,
                "unknown",
                "The Complete Works of William Shakespeare");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Economics\\cover-auto-6487.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Economics\\An-Inquiry-into-the-Nature-and-Causes-of-the-Wealth-of-Nations.pdf",
                5L,
                10L,
                "An account of economics at the dawn of the Industrial Revolution, as well as a rhetorical piece written for the generally educated individual of the 18th century - advocating a free market economy as more productive and more beneficial to society. --Wikipedia",
                955,
                "1776",
                "An Inquiry into the Nature and Causes of the Wealth of Nations");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Educational\\cover-cust-2473.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Educational\\Relativity---The-Special-and-General-Theory.pdf",
                6L,
                6L,
                "Revised edition: 1924 (note: images are not included in this eBook.)",
                97,
                "1916",
                "Relativity - The Special and General Theory");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Fantasy\\cover-orig-955.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Fantasy\\The-Wonderful-Wizard-of-Oz.pdf",
                7L,
                3L,
                "To quote a reader, ''If all you know of Oz comes from the movie musical then you owe it to yourself to read the book that inspired Hollywood.'' Learn about Dorothy and her friends in the first of thirteen volumes by L. Frank Baum.",
                123,
                "1901",
                "The Wonderful Wizard of Oz");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Horror\\cover-cust-13095.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Horror\\The-Call-of-Cthulhu.pdf",
                11L,
                9L,
                "Three independent narratives linked together by the device of a narrator discovering notes left by a deceased relative. Piecing together the whole truth and disturbing significance of the information he possesses, the narrator's final line is ''The most merciful thing in the world, I think, is the inability of the human mind to correlate all its contents.''",
                28,
                "1926",
                "The Call of Cthulhu");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Personal\\cover-orig-7949.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Personal\\How-to-Use-Your-Mind.pdf",
                8L,
                11L,
                "Educational leaders are seeing with increasing clearness the necessity of teaching students not only the subject-matter of study but also methods of study. The recognition of this condition is taking the form of the movement toward ''supervised study,'' which attempts to acquaint the student with principles of economy and directness in using his mind. It is generally agreed that there are certain ''tricks'' which make for mental efficiency, consisting of methods of apperceiving facts, methods of review, devices for arranging work. Some are the fruits of psychological experimentation; others are derived from experience. Many of them can be imparted by instruction, and it is for the purpose of systematizing these and making them available for students that this book is prepared.",
                124,
                "1921",
                "How to Use Your Mind");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Romance\\cover-cust-699.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Romance\\Pride-and-Prejudice.pdf",
                9L,
                2L,
                "Austen's finest comedy of manners portrays life in the genteel rural society of the early 1800s, and tells of the initial misunderstandings (and mutual enlightenment) between lively and quick witted Elizabeth Bennet and the haughty Mr. Darcy.",
                360,
                "1913",
                "Pride and Prejudice");

        bookService.createSingleCategoryBook("D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Sci-Fi\\cover-cust-7349.jpg",
                "D:\\University\\Web\\Web1\\src\\main\\java\\com\\example\\web1\\PDFs\\Sci-Fi\\The-Time-Machine.pdf",
                10L,
                1L,
                "A brilliant fantasy beyond conventional thought...",
                79,
                "1895",
                "The Time Machine");
*/



    }



}
