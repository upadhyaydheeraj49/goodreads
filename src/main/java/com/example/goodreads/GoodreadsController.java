package com.example.goodreads;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import com.example.goodreads.Book;
import com.example.goodreads.BookService;

@RestController
public class GoodreadsController {
    // controller class
    BookService bService = new BookService();

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        return bService.getBookById(bookId);

    }

}