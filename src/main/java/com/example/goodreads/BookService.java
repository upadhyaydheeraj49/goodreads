package com.example.goodreads;

import com.example.goodreads.Book;
import com.example.goodreads.BookRepository;
import java.util.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

public class BookService implements BookRepository {

    // business logic
    private HashMap<Integer, Book> hmap = new HashMap<>();

    public BookService() {
        Book book1 = new Book(1, "Harry Potter", "harry_potter.jpg");
        Book book2 = new Book(2, "Jungle Book", "jungle_book.jpg");
        hmap.put(book1.getId(), book1);
        hmap.put(book2.getId(), book2);
    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> booksCollection = hmap.values();
        ArrayList<Book> books = new ArrayList<>(booksCollection);
        return books;

    }

    @Override
    public Book getBookById(int id) {
        Book b = hmap.get(id);
        if (b == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return b;
    }

}