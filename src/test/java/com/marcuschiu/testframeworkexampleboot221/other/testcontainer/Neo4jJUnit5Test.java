package com.marcuschiu.testframeworkexampleboot221.other.testcontainer;

import org.junit.jupiter.api.Test;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Testcontainers
class Neo4jJUnit5Test {

    @Container
    private static Neo4jContainer neo4jContainer = new Neo4jContainer()
            .withAdminPassword(null); // Disable password

    @Test
    void testSomethingUsingBolt() {
        // Retrieve the Bolt URL from the container
        String boltUrl = neo4jContainer.getBoltUrl();
        try (
                Driver driver = GraphDatabase.driver(boltUrl, AuthTokens.none());
                Session session = driver.session()
        ) {
            long one = session.run("RETURN 1", Collections.emptyMap()).next().get(0).asLong();
            assertEquals(1, one);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testSomethingUsingHttp() throws IOException {

        // Retrieve the HTTP URL from the container
        String httpUrl = neo4jContainer.getHttpUrl();

        URL url = new URL(httpUrl + "/db/data/transaction/commit");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (Writer out = new OutputStreamWriter(con.getOutputStream())) {
            out.write("{\"statements\":[{\"statement\":\"RETURN 1\"}]}");
            out.flush();
        }

        assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode());
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String expectedResponse = "{\"results\":[{\"columns\":[\"1\"],\"data\":[{\"row\":[1],\"meta\":[null]}]}],\"errors\":[]}";
            String response = buffer.lines().collect(Collectors.joining("\n"));
            assertEquals(expectedResponse, response);
        }
    }
}