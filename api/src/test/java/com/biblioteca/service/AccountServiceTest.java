package com.biblioteca.service;

import com.biblioteca.builder.model.AccountBuilder;
import com.biblioteca.mapper.AccountMapper;
import com.biblioteca.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AccountServiceTest {
    private AccountService accountService;

    @Mock
    AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        initMocks(this);

        accountService = new AccountService(accountMapper);
    }

    @Test
    void shouldCreateAccount() {
        Account account = new AccountBuilder().build();

        accountService.createUser(account);

        verify(accountMapper).insert(account);
    }
}
