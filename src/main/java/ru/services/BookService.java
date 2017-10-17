package ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entities.Book;
import ru.filters.SearchFilter;
import ru.interfaces.BookDAO;

import java.util.List;

/**
 * Created by ruslan on 14.10.17.
 */
@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public  List<Book> allBooks(SearchFilter searchFilter) {
        searchFilter.setFirst(0);
        return bookDAO.allBooks(searchFilter);
    }
    public List<Book> booksBySearch(SearchFilter searchFilter) {
        searchFilter.setFirst(0);
        return bookDAO.booksBySearch(searchFilter);
    }

    public List<Book> nextPage(SearchFilter searchFilter) {
        searchFilter.setFirst(searchFilter.getFirst() + searchFilter.getBookOnPage());
        return bookDAO.booksBySearch(searchFilter);
    }

    public List<Book> prevPage(SearchFilter searchFilter) {
        searchFilter.setFirst(searchFilter.getFirst() - searchFilter.getBookOnPage());
        return bookDAO.booksBySearch(searchFilter);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    public void createBook(Book book) {
        bookDAO.addBook(book);
    }

    public Book bookById(int id) {
        return bookDAO.bookById(id);
    }
}
