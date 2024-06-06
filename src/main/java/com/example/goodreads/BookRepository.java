package com.example.goodreads;

import java.util.*;
import com.example.goodreads.Book;

public interface BookRepository {
    //interface for maintaining data consistency and abstraction
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);
}