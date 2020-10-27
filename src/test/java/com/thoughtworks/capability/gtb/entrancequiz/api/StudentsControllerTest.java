package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.service.StudentGroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    StudentGroupService studentGroupService;

    @Test
    public void shouldGetStudents() throws Exception {

        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$[0].name",is("成吉思汗")))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[6].name",is("芈月")))
                .andExpect(jsonPath("$[6].id",is(7)))
                .andExpect(jsonPath("$[12].name",is("哪吒")))
                .andExpect(jsonPath("$[12].id",is(13)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateStudent() throws Exception {
        String name = "盲僧";
        mockMvc.perform(post("/student").contentType(MediaType.APPLICATION_JSON)
                .content(name))
                .andExpect(status().isCreated());
        assertEquals(16, studentGroupService.getStudents().size());
        assertEquals(16, studentGroupService.getStudents().get(15).getId());
        assertEquals("盲僧", studentGroupService.getStudents().get(15).getName());

    }

    @Test
    public void shouldDivideGroups()throws Exception {
        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk());
    }
}