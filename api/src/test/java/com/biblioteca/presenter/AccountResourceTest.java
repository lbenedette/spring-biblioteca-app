package com.biblioteca.presenter;

import com.biblioteca.builder.model.AccountBuilder;
import com.biblioteca.model.Account;
import com.biblioteca.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountResource.class)
public class AccountResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void createAnAccount() throws Exception {
        String email = "test@example.com";
        String password = "@Password1";
        String passwordConfirmation = "@Password1";
        String name = "John Doe";
        String phoneNumber = "551699778852";

        String accountAsJson = "{" +
            "\"email\": \"" + email + "\", " +
            "\"name\": \"" + name + "\", " +
            "\"password\": \"" + password + "\", " +
            "\"passwordConfirmation\": \"" + passwordConfirmation + "\", " +
            "\"phoneNumber\": \"" + phoneNumber + "\"" +
            "}";

        Account createdAccount = new AccountBuilder()
            .withEmail(email)
            .withName(name)
            .withPassword(password)
            .withPhoneNumber(phoneNumber)
            .build();

        mockMvc.perform(
            post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(accountAsJson))
            .andExpect(status().isCreated());

        verify(accountService).createUser(createdAccount);
    }
}
