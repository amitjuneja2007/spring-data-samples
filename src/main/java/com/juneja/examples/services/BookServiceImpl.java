package com.juneja.examples.services;

import com.juneja.examples.domain.Book;
import com.juneja.examples.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}
