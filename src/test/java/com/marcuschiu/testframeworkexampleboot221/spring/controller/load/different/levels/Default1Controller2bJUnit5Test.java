package com.marcuschiu.testframeworkexampleboot221.spring.controller.load.different.levels;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @SpringBootTest = @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
 * @AutoConfigureMockMvc
 * - adds a MockMvc instance to the application context
 * - Test Controller by loading the full Spring application context but without the server
 */
@SpringBootTest // == @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class Default1Controller2bJUnit5Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
//                .andDo(print()) // sys output test stuff
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }
}
