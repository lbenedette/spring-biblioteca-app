package com.biblioteca.presenter;

import com.biblioteca.model.Book;
import com.biblioteca.presenter.dto.BooksResponse;
import com.biblioteca.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<BooksResponse> getAllBooks() {
        List<Book> books = bookService.findAll();
        BooksResponse booksResponse = new BooksResponse(books);

        return ResponseEntity.ok(booksResponse);
    }
}
