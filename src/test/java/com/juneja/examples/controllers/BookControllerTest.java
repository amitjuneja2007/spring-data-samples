package com.juneja.examples.controllers;

import com.juneja.examples.domain.Book;
import com.juneja.examples.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    BookService bookService;

    @Test
    void testGetByIdResponse() throws Exception {
        Book book = new Book(1L, "Test Title", "Test isbn");

        given(bookService.getById(any())).willReturn(book);

        mockMvc.perform(get("/api/v1/book/" + 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        // Arrange
        List<Book> books = Arrays.asList(
                new Book(1L, "1984", "George Orwell"),
                new Book(2L, "To Kill a Mockingbird", "Harper Lee")
        );
        when(bookService.getAllBooks()).thenReturn(books);

        // Act & Assert
        mockMvc.perform(get("/api/v1/book"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("1984"))
                .andExpect(jsonPath("$[1].title").value("To Kill a Mockingbird"));
    }
}