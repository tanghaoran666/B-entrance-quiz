package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.service.StudentGroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    StudentGroupService studentGroupService;

    @BeforeEach
    void setUp(){
        studentGroupService.init();
    }

    @Test
    public void shouldGetGoods() throws Exception {

        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$",hasSize(15)))
                .andExpect(jsonPath("$[0].name",is("成吉思汗")))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[6].name",is("芈月")))
                .andExpect(jsonPath("$[6].id",is(7)))
                .andExpect(jsonPath("$[12].name",is("哪吒")))
                .andExpect(jsonPath("$[12].id",is(13)))
                .andExpect(status().isOk());
    }
}