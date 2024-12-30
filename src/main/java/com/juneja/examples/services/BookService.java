package com.juneja.examples.services;

import com.juneja.examples.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    Book getById(Long id);
    List<Book> getAllBooks();
}
