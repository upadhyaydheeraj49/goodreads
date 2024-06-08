package com.example.goodreads;

import com.example.goodreads.Book;
import com.example.goodreads.BookRepository;
import java.util.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

public class BookService implements BookRepository {

    // business logic
    private HashMap<Integer, Book> hmap = new HashMap<>();
    int uniqueId = 3;

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

    @Override
    public Book addBook(Book book) {
        book.setId(uniqueId);
        hmap.put(uniqueId, book);
        uniqueId++;
        return book;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book existingBook = hmap.get(id);

        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (book.getName() != null) {
            existingBook.setName(book.getName());
        }
        if (book.getUrl() != null) {
            existingBook.setUrl(book.getUrl());
        }
        return existingBook;
    }

    @Override
    public void deleteBook(int id) {
        Book book = hmap.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            hmap.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}