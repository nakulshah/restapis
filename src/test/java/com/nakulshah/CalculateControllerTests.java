package com.nakulshah;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateDefault() throws Exception {

        this.mockMvc.perform(post("/calculate")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(0));
    }

    @Test
    public void calculateAddition() throws Exception {

        String requestBody = "{\"num1\": 2, \"num2\": 3, \"operator\": \"+\"}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

}
