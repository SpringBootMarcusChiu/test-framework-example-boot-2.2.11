package com.marcuschiu.testframeworkexampleboot221.controller.dependencies;

import com.marcuschiu.testframeworkexampleboot221.controller.Default2Controller;
import com.marcuschiu.testframeworkexampleboot221.service.Default1Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest(Default2Controller.class)
 * - just loads Default2Controller.class not every @Controller beans
 * - contains:
 *   - @AutoConfigureCache -
 *   - @AutoConfigureWebMvc - adds WebMvc into application context
 *   - @AutoConfigureMockMvc - adds MockMvc into application context
 *   - @ImportAutoConfiguration -
 */
//@ExtendWith({SpringExtension.class}) included in @WebMvcTest
@WebMvcTest(Default2Controller.class)
public class Default2Controller1JUnit5Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Default1Service service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.greet()).thenReturn("Hello, Mock");

        mockMvc.perform(get("/default/2"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }
}