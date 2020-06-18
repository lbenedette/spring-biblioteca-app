package com.biblioteca.persistence;

import com.biblioteca.mapper.BookMapper;
import com.biblioteca.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BookMapperTest extends MapperTestBase {
    private BookMapper bookMapper;

    @Override
    @BeforeEach
    void setUp() throws Exception {
        super.setUp();
        bookMapper = getSqlSession().getMapper(BookMapper.class);
    }

    @Test
    void shouldInsertANewBook() throws Exception {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");
        bookMapper.insert(book);
        assertThat(book.getId(), is(not(nullValue())));

        ResultSet resultSet = execute("select * from book where book_id = " + book.getId() + ";");
        resultSet.next();
        assertBook(book, resultSet);
    }

    @Test
    void shouldFindAllBooks() throws Exception {
        int before = bookMapper.findAll().size();

        Book book = new Book("The Two Towers", "J. R. R. Tolkien", "1954");
        bookMapper.insert(book);

        assertThat(bookMapper.findAll().size(), is(before + 1));
    }

    private void assertBook(Book expected, ResultSet actual) throws SQLException {
        assertThat(expected.getId(), is(actual.getInt("book_id")));
        assertThat(expected.getTitle(), is(actual.getString("title")));
        assertThat(expected.getAuthor(), is(actual.getString("author")));
        assertThat(expected.getYearPublished(), is(actual.getString("year_published")));
    }
}
