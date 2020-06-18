package com.biblioteca.presenter;

import com.biblioteca.model.Book;
import com.biblioteca.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Test
    public void shouldGetAllBooks() throws Exception {
        List<Book> expectedBooks = singletonList(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));
        when(bookService.findAll()).thenReturn(expectedBooks);

        mockMvc.perform(get("/books")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.books", hasSize(1)))
                .andExpect(jsonPath("$.books[0].title").value("The Fellowship Of The Ring"));
    }
}
