package com.example.demo.controller;

import com.example.demo.models.Capital;
import com.example.demo.repositories.CapitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CapitalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CapitalRepository mockRepository;

    @BeforeEach
    public void init() throws Exception {
        Capital c1 = new Capital("Moscow", 1L);
        Capital c2 = new Capital("Seoul", 2L);
        Capital c3 = new Capital("Tokyo", 3L);
        when(mockRepository.findById(1L)).thenReturn(Optional.of(c1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

    }

    @Test
    public void addCapitalTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/capital/add?name=Bangkok").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Bangkok was added")));
    }

    @Test
    public void getByIdTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/capital/getById?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Moscow\"}"));
    }

}













