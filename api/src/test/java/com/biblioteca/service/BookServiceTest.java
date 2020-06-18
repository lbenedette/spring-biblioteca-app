package com.biblioteca.service;

import com.biblioteca.mapper.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookServiceTest {

    @Mock
    BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void shouldGetBooks() {
        BookService bookService = new BookService(bookMapper);
        bookService.findAll();

        verify(bookMapper).findAll();
    }
}
