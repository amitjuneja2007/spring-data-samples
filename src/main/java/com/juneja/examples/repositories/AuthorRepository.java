package com.juneja.examples.repositories;

import com.juneja.examples.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
