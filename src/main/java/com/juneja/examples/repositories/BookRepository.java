package com.juneja.examples.repositories;

import com.juneja.examples.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
