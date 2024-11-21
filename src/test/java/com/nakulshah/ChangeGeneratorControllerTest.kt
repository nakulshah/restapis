package com.nakulshah

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class ChangeGeneratorControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testChangeGenerator(): Unit {
        val requestBody = """{"price":17.56,"payment":20}"""
        mockMvc.post("/transaction") {
            contentType = MediaType.APPLICATION_JSON
            content = requestBody}.andDo { print() }
    }
}