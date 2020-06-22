package com.biblioteca.persistence;

import com.biblioteca.builder.model.AccountBuilder;
import com.biblioteca.mapper.AccountMapper;
import com.biblioteca.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountMapperTest extends MapperTestBase {
    private AccountMapper accountMapper;

    @BeforeEach
    void setUp() throws Exception {
        super.setUp();
        accountMapper = getSqlSession().getMapper(AccountMapper.class);
    }

    @Test
    void shouldInsert() throws Exception {
        Account account = new AccountBuilder()
            .withName("Bilbo Baggins")
            .build();

        accountMapper.insert(account);
        assertThat(account.getId(), is(notNullValue()));

        ResultSet resultSet = execute("select * from account where account_id = " + account.getId() + ";");
        resultSet.next();
        assertAccount(account, resultSet);
    }

    private void assertAccount(Account expected, ResultSet actual) throws SQLException {
        assertThat(expected.getId(), is(actual.getInt("account_id")));
        assertThat(expected.getEmail(), is(actual.getString("email")));
        assertThat(expected.getName(), is(actual.getString("name")));
        assertThat(expected.getPassword(), is(actual.getString("password")));
        assertThat(expected.getPhoneNumber(), is(actual.getString("phone_number")));
    }
}
