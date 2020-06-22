package com.biblioteca.model;

import java.util.Objects;

public class Account {
    private Integer id;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;

    public Account() {
    }

    public Account(String email, String name, String password, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Account(Integer id, String email, String name, String password, String phoneNumber) {
        this(email, name, password, phoneNumber);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(email, account.email) &&
            Objects.equals(name, account.name) &&
            Objects.equals(password, account.password) &&
            Objects.equals(phoneNumber, account.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, phoneNumber);
    }
}
