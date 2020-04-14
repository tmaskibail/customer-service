package com.maskibail.service.customer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@Configuration
public class BaseDbConfig {
    private static final Logger LOG = LoggerFactory.getLogger(BaseDbConfig.class);

    @Bean
    public MySQLContainer mysqlContainer() {
        final MySQLContainer mysqlContainer = new MySQLContainer();
        mysqlContainer.start();
        return mysqlContainer;
    }

    @Bean
    public DataSource getDataSource(final MySQLContainer mysqlContainer) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(mysqlContainer.getDriverClassName());
        dataSourceBuilder.url(mysqlContainer.getJdbcUrl());
        dataSourceBuilder.username(mysqlContainer.getUsername());
        dataSourceBuilder.password(mysqlContainer.getPassword());
        DataSource dataSource = dataSourceBuilder.build();
        return dataSource;
    }

}
