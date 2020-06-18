package com.biblioteca.mapper;

import com.biblioteca.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    String BOOK_RESULT_MAPPING = "bookResultMapping";

    @Insert(
        "INSERT INTO book (title, author, year_published) " +
        "VALUES (#{title}, #{author}, #{yearPublished})"
    )
    @Options(keyProperty = "id", keyColumn = "book_id", useGeneratedKeys = true)
    void insert(Book book);

    @Select(
        "SELECT book_id, title, author, year_published FROM book ORDER BY book_id"
    )
    @Results(id = BOOK_RESULT_MAPPING, value = {
        @Result(property = "id", column = "book_id"),
        @Result(property = "yearPublished", column = "year_published")
    })
    List<Book> findAll();
}
