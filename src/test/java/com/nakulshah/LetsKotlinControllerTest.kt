package com.nakulshah

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class LetsKotlinControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    public fun defaultLetsKotlinShallReturnDefault(): Unit {
        mockMvc.get("/letskotlin?name=Yo").andDo { print() }
            .andExpect {
                status { isOk() }
                content { json("{\"name\":\"Yo\",\"message\":\"Let's Kotlin, Yo!\"}") }
            }
    }
}