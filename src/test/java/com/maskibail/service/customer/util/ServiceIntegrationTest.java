package com.maskibail.service.customer.util;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceIntegrationTest {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceIntegrationTest.class);

    @Autowired
    private DataSource dataSource;

    @Test
    void testToShowcaseMqSQLTestContainer() throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        statement.executeUpdate("CREATE TABLE test.Foo (ID INT PRIMARY KEY);");
        LOG.info("Created table FOO in test database");
        statement = dataSource.getConnection().createStatement();
        statement.executeUpdate("INSERT INTO test.Foo (ID) VALUES (3);");
        LOG.info("Inserted a record into test.FOO table with ID: 3");
        statement = dataSource.getConnection().createStatement();
        statement.execute("SELECT * FROM  test.Foo;");
        ResultSet resultSet = statement.getResultSet();

        resultSet.next();
        int resultSetInt = resultSet.getInt("ID");
        assertEquals("A basic SELECT query succeeds", 3, resultSetInt);
    }
}
