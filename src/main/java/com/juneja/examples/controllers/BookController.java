package com.juneja.examples.controllers;

import com.juneja.examples.domain.Book;
import com.juneja.examples.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long bookId) {
        return this.bookService.getById(bookId);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }
}
