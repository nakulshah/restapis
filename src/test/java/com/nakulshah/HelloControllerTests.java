package com.nakulshah;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamHelloShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello World!"));
    }
}
