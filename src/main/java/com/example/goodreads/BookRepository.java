package com.example.goodreads;

import java.util.*;
import com.example.goodreads.Book;

public interface BookRepository {
    // interface for maintaining data consistency and abstraction
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

    Book addBook(Book book);

    Book updateBook(int id, Book book);

    void deleteBook(int id);
}