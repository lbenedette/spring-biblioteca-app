package com.biblioteca.service;

import com.biblioteca.mapper.AccountMapper;
import com.biblioteca.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Integer createUser(Account account) {
        accountMapper.insert(account);
        return account.getId();
    }
}
