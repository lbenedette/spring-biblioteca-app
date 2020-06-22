package com.biblioteca.mapper;

import com.biblioteca.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface AccountMapper {
    String ACCOUNT_RESULT_MAPPING = "accountResultMapping";

    @Insert(
        "INSERT INTO account (email, name, password, phone_number) " +
        "VALUES (#{email}, #{name}, #{password}, #{phoneNumber})"
    )
    @Options(keyProperty = "id", keyColumn = "account_id", useGeneratedKeys = true)
    void insert(Account account);
}
