package com.example.mvc.exception

import com.example.mvc.model.UserRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap

/**
 * Project        : mvc
 * DATE           : 2023/03/10
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/10      dnejdzlr2          최초 생성
 */
@WebMvcTest
@AutoConfigureMockMvc
internal class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "woodo")
        queryParams.add("age", "20")

        mockMvc.perform(
            get("/api/exception").queryParams(queryParams)
        ).andExpect(
            status().isOk
        ).andExpect(
            content().string("woodo 20")
        ).andDo(print())

    }

    @Test
    fun getFailTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "woodo")
        queryParams.add("age", "9")

        mockMvc.perform(
            get("/api/exception").queryParams(queryParams)
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            content().contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
            jsonPath("\$.result_code").value("FAIL")
        ).andExpect(
            jsonPath("\$.errors[0].filed").value("age")
        ).andExpect(
            jsonPath("\$.errors[0].value").value(9)
        ).andDo(print())

    }

    @Test
    fun postTest() {
        val userRequest = UserRequest().apply {
            this.name = "woodo"
            this.age = 10
            this.phoneNumber = "010-2222-3333"
            this.address = "부부부부부"
            this.email = "dddnejdzlr2@naver.com"
            this.createdAt = "2023-03-02 10:10:22"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)
        println(json)

        mockMvc.perform(
            post("/api/exception")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            status().isOk
        ).andExpect(
            jsonPath("\$.name").value("woodo")
        ).andExpect(
            jsonPath("\$.age").value("10")
        ).andExpect(
            jsonPath("\$.email").value("dddnejdzlr2@naver.com")
        ).andDo(print())

    }

    @Test
    fun postFailTest() {
        val userRequest = UserRequest().apply {
            this.name = "woodo"
            this.age = -1
            this.phoneNumber = "010-2222-3333"
            this.address = "부부부부부"
            this.email = "dddnejdzlr2@naver.com"
            this.createdAt = "2023-03-02 10:10:22"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)
        println(json)

        mockMvc.perform(
            post("/api/exception")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            jsonPath("\$.errors[0].filed").value("age")
        ).andDo(print())

    }
}

