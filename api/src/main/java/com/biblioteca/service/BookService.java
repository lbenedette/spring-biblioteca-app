package com.biblioteca.service;

import com.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    public List<Book> findAll() {
        return new ArrayList<>();
    }
}
