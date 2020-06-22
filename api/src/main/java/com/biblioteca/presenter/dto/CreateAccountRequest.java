package com.biblioteca.presenter.dto;

import com.biblioteca.model.Account;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountRequest {
    private final String email;
    private final String name;
    private final String password;
    private final String passwordConfirmation;
    private final String phoneNumber;

    @JsonCreator
    public CreateAccountRequest(@JsonProperty("email") String email,
                                @JsonProperty("name") String name,
                                @JsonProperty("password") String password,
                                @JsonProperty("passwordConfirmation") String passwordConfirmation,
                                @JsonProperty("phoneNumber") String phoneNumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.phoneNumber = phoneNumber;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setEmail(this.email);
        account.setName(this.name);
        account.setPassword(this.password);
        account.setPhoneNumber(this.phoneNumber);
        return account;
    }
}
