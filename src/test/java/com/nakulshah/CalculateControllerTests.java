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

        this.mockMvc.perform(post("/calculate")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void calculateAddition() throws Exception {

        String requestBody = "{\"num1\": 2, \"num2\": 3, \"operator\": \"+\"}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    public void calculateSubtraction() throws Exception {

        String requestBody = "{\"num1\": 3, \"num2\": 2, \"operator\": \"-\"}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1));
    }

    @Test
    public void calculateMultiplication() throws Exception {

        String requestBody = "{\"num1\": 3, \"num2\": 2, \"operator\": \"*\"}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));
    }

    @Test
    public void calculateDivision() throws Exception {

        String requestBody = "{\"num1\": 3, \"num2\": 2, \"operator\": \"/\"}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1));
    }

    @Test
    public void calculateBadOperator() throws Exception {

        String requestBody = "{\"num1\": 3, \"num2\": 2, \"operator\": \"x\"}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(0));
    }

    @Test
    public void calculateNullOperator() throws Exception {

        String requestBody = "{\"num1\": 3, \"num2\": 2}";

        this.mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(0));
    }

}
