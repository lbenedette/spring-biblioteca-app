package com.biblioteca.presenter.dto;

import com.biblioteca.model.Book;

import java.util.List;

public class BooksResponse {
    private final List<Book> books;

    public BooksResponse(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
