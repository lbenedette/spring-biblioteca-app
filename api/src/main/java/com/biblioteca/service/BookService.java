package com.biblioteca.service;

import com.biblioteca.mapper.BookMapper;
import com.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> findAll() {
        return bookMapper.findAll();
    }
}
