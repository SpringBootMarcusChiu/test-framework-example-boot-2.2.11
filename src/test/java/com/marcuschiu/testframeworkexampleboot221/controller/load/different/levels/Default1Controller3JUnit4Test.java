package com.marcuschiu.testframeworkexampleboot221.controller.load.different.levels;

import com.marcuschiu.testframeworkexampleboot221.service.Default1Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @RunWith(SpringRunner.class)
 * - provides support for loading a Spring ApplicationContext and having
 *   beans @Autowired into your test instance
 * @WebMvcTest
 * - Test Controller by only loading the web layer (this includes Default2Controller)
 * - contains:
 *   - @AutoConfigureCache -
 *   - @AutoConfigureWebMvc - adds WebMvc into application context
 *   - @AutoConfigureMockMvc - adds MockMvc into application context
 *   - @ImportAutoConfiguration -
 * This test will FAIL if any controller has dependencies! UNLESS @MockBean for each Autowired bean/component
 */
@RunWith(SpringRunner.class) // REQUIRED FOR JUNIT 4
@WebMvcTest
public class Default1Controller3JUnit4Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Default1Service default1Service; // dependency for Default2Controller

    @org.junit.Test
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        tee(list);
        System.out.println(list.toString());
    }

    public void tee(final List<String> list) {
        list.add("hello");
    }
}