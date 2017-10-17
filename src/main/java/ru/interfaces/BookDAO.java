package ru.interfaces;

import ru.entities.Book;
import ru.filters.SearchFilter;

import java.util.List;

/**
 * Created by ruslan on 14.10.17.
 */
public interface BookDAO {
    List<Book> allBooks(SearchFilter searchFilter);
    List<Book> booksBySearch(SearchFilter searchFilter);
    Book bookById(int id);
    void updateBook(Book book);
    void addBook(Book book);
    void deleteBook(int id);
}
