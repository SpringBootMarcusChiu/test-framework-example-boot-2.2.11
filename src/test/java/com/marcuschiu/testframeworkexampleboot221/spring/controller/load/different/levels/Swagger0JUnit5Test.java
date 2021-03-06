package com.marcuschiu.testframeworkexampleboot221.spring.controller.load.different.levels;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing Controller By Starting Entire Server
 * WebEnvironment=RANDOM_PORT to start an EMBEDDED http server with a random port (useful to avoid conflicts in test environments)
 * WebEnvironment=DEFINED_PORT to start an EMBEDDED http server with application.properties port
 * WebEnvironment=MOCK to start a MOCK http server
 * WebEnvironment=NONE no http server
 */
// similar to MockMVC with an application context
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class Swagger0JUnit5Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage2() throws Exception {
        mockMvc.perform(get("/swagger-ui.html"))
//                .andDo(print()) // sys output test stuff
                .andExpect(status().isOk());
    }
}
