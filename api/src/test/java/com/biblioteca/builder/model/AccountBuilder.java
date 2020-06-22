package com.biblioteca.builder.model;

import com.biblioteca.model.Account;

import static java.util.UUID.randomUUID;

public class AccountBuilder {
    private Integer id = null;
    private String email = randomUUID() + "some.body@example.com";
    private String name = "Some Body";
    private String password = "@Password1";
    private String phoneNumber = "123456789";

    public AccountBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public AccountBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AccountBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public AccountBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Account build() {
        return new Account(id, email, name, password, phoneNumber);
    }
}
