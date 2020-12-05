package com.marcuschiu.testframeworkexampleboot221.controller.load.different.levels;

import com.marcuschiu.testframeworkexampleboot221.service.Default1Service;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest - Test Controller by only loading the web layer (this includes Default2Controller)
 * This test will FAIL if any controller has dependencies! UNLESS @MockBean for each Autowired bean/component
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class Default1Controller3Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Default1Service default1Service; // for Default2Controller

    @org.junit.Test
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }
}