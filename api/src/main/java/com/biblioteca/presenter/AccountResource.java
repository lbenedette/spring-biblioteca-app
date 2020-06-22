package com.biblioteca.presenter;

import com.biblioteca.model.Account;
import com.biblioteca.presenter.dto.CreateAccountRequest;
import com.biblioteca.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountResource {
    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Account account = createAccountRequest.toAccount();
        accountService.createUser(account);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
