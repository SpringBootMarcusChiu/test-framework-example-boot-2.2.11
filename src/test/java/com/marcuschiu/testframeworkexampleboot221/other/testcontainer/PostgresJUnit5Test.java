package com.marcuschiu.testframeworkexampleboot221.other.testcontainer;


import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
class PostgresJUnit5Test {

    // will be started before and stopped after each test method
    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer()
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");

    @Test
    void test() {
        assertTrue(postgresqlContainer.isRunning());
    }
}
