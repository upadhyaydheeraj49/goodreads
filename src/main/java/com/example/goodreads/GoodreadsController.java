package com.example.goodreads;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bService.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        return bService.updateBook(bookId, book);

    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bService.deleteBook(bookId);
    }
}