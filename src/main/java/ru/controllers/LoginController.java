package ru.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.entities.Book;
import ru.filters.SearchFilter;
import ru.services.BookService;

import java.util.List;

@Controller
@SessionAttributes(value = "searchFilter")
public class LoginController {
    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(@ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        List<Book> books = bookService.allBooks(searchFilter);
        model.addAttribute("books", books);
        return "main";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        model.addAttribute("books", bookService.booksBySearch(searchFilter));
        return "main";
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public String next(@ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
//        System.out.println(searchFilter);
        model.addAttribute("books", bookService.nextPage(searchFilter));
        return "main";
    }

    @RequestMapping(value = "/prev", method = RequestMethod.GET)
    public String prev(@ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
//        System.out.println(searchFilter);
        model.addAttribute("books", bookService.prevPage(searchFilter));
        return "main";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(@RequestParam String bookId, @ModelAttribute("searchFilter") SearchFilter searchFilter, Model model) {
        int id = Integer.valueOf(bookId);
        Book book = bookService.bookById(id);
        model.addAttribute("book", book);
        return "update";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBook(@RequestParam String bookId,
                             @ModelAttribute SearchFilter searchFilter,
                             Model model) {
        int id = Integer.valueOf(bookId);
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.booksBySearch(searchFilter));
        return "main";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute SearchFilter searchFilter,
                           @ModelAttribute Book book,
                           @RequestParam(required = false) String newBook,
                           Model model) {
        book.setReadAlready((byte)0);

        if (newBook != null) {
            bookService.createBook(book);
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.booksBySearch(searchFilter));
        return "main";
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public String readBook(@RequestParam String bookId,
                           Model model) {
        int id = Integer.valueOf(bookId);
        Book book = bookService.bookById(id);
        if (book.getReadAlready() == 0) {
            book.setReadAlready((byte) 1);
            bookService.updateBook(book);
        }
        model.addAttribute("book", book);
        return "read";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBook(@ModelAttribute SearchFilter searchFilter,
                             Model model) {

        System.out.println(searchFilter);

        model.addAttribute("books", bookService.booksBySearch(searchFilter));
        model.addAttribute("book", new Book());
        return "create";
    }

    @ModelAttribute(value = "searchFilter")
    private SearchFilter createSearchFilter(){
        return new SearchFilter();
    }
}
