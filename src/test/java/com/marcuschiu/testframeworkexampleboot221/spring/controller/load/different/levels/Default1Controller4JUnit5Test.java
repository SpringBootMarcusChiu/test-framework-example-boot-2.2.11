package com.marcuschiu.testframeworkexampleboot221.spring.controller.load.different.levels;

import com.marcuschiu.testframeworkexampleboot221.spring.controller.Default1Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest(Default1Controller.class)
 * - Test Controller by only loading a specific Controller in the web layer
 */
//@ExtendWith(SpringExtension.class) // Included in @WebMvcTest
@WebMvcTest(Default1Controller.class)
public class Default1Controller4JUnit5Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }
}
