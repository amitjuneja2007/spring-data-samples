package com.juneja.examples.repositories;

import com.juneja.examples.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
