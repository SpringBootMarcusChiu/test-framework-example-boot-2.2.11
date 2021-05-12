package com.marcuschiu.testframeworkexampleboot221.other.testcontainer;

import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostgresJUnit4Test {
//
//    @Rule
//    public PostgreSQLContainer postgresContainer = new Postgres();
//
//    @Test
//    public void whenSelectQueryExecuted_thenResultsReturned() throws Exception {
//        String jdbcUrl = postgresContainer.getJdbcUrl();
//        String username = postgresContainer.getUsername();
//        String password = postgresContainer.getPassword();
//        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
//
//        ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1");
//
//        resultSet.next();
//        int result = resultSet.getInt(1);
//        assertEquals(1, result);
//    }
}
