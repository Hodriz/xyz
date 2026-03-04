package com.example.xyz.controller;

import com.example.xyz.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PessoaController.class)
class PessoaControllerTest {
    @Mock
    private MockMvc mockMvc;

    @InjectMocks
    PessoaService pessoaService;

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}