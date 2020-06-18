package com.biblioteca.persistence;

import com.biblioteca.configuration.MyBatisConfiguration;
import com.biblioteca.persistence.helpers.DatabasePreparationUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.ResultSet;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = MyBatisConfiguration.class)
abstract class MapperTestBase {
    @Autowired
    private MyBatisConfiguration myBatisConfiguration;

    @Autowired
    private Environment environment;

    private SqlSession sqlSession;

    @BeforeEach
    void setUp() throws Exception {
        String activeProfile = Arrays.asList(environment.getActiveProfiles()).get(0);
        DatabasePreparationUtils.executeMyBatisMigrations(activeProfile);

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(myBatisConfiguration.dataSource());
        factoryBean.setConfigLocation(new ClassPathResource("mybatis.config.xml"));

        // Allow rollbacks
        factoryBean.setTransactionFactory(new JdbcTransactionFactory());

        sqlSession = factoryBean.getObject().openSession();
    }

    @Test
    void testEnv() {
        assertThat(myBatisConfiguration.url).contains("test");
    }

    @AfterEach
    void tearDown() {
        sqlSession.rollback();
        sqlSession.close();
    }

    SqlSession getSqlSession() {
        return sqlSession;
    }

    ResultSet execute(String statement) throws Exception {
        return sqlSession.getConnection().prepareStatement(statement).executeQuery();
    }
}
