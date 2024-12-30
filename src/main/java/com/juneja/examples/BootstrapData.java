package com.juneja.examples;

import com.juneja.examples.domain.Author;
import com.juneja.examples.domain.Book;
import com.juneja.examples.domain.Publisher;
import com.juneja.examples.repositories.AuthorRepository;
import com.juneja.examples.repositories.BookRepository;
import com.juneja.examples.repositories.PublisherRepository;
import jakarta.annotation.Nonnull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;


    private final BookRepository bookRepository;


    private final PublisherRepository publisherRepository;

    public BootstrapData(@Nonnull AuthorRepository authorRepository, @Nonnull BookRepository bookRepository, @Nonnull PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    //@TODO : reformat below code
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Doing bootstrap data seeding...");
        Author eric = new Author("Eric", "Evans");
        Author rod = new Author("Rod", "Johnson");
        authorRepository.saveAll(Set.of(eric, rod));


        Book ddd = new Book("Domain Driven Design", "123456");
        Book noEJB = new Book("J2EE Development without EJB", "54757585");


        bookRepository.saveAll(Set.of(noEJB, ddd));


        Publisher publisher = new Publisher("Hello Hills", "Toronto Ontario Canada");
        publisherRepository.save(publisher);

        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }

}
