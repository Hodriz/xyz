package com.example.xyz.controller;

import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.entity.Funcao;
import com.example.xyz.service.VeiculoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VeiculoController.class)
class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VeiculoService veiculoService;

    @Test
    void criar() throws Exception {

        given(veiculoService.createVeiculo(any()))
                .willReturn(new VeiculoResponse(
                        1l,"Uno","Fiat", Funcao.PASSEIO,2009
                ));

        mockMvc.perform(post("/veiculos")
                .content("""
                {
                  "modelo":"Uno",
                  "marca":"Fiat",
                  "funcao":"PASSEIO",
                  "ano":2009
                }
            """).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("Uno"))
                .andExpect(jsonPath("$.marca").value("Fiat"));
    }

    @Test
    void update() throws Exception{

        VeiculoResponse response =
                new VeiculoResponse(1l,"Civic","Honda",Funcao.PASSEIO,2022);

        given(veiculoService.updateVeiculo(eq(1L), any()))
                .willReturn(response);

        mockMvc.perform(put("/veiculos/1")
                        .content("""
                    {
                      "modelo":"Civic",
                      "marca":"Honda",
                      "funcao":"PASSEIO",
                      "ano":2022
                    }
                """)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("Civic"))
                .andExpect(jsonPath("$.marca").value("Honda"));

        then(veiculoService).should().updateVeiculo(eq(1L), any());
    }

    @Test
    void readAll() throws Exception{

        VeiculoResponse v=new VeiculoResponse(1L,
                "Corolla","Toyota",Funcao.EXECUTIVO,2023);

        given(veiculoService.readAllVeiculo())
                .willReturn(List.of(v));

        mockMvc.perform(get("/veiculos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].modelo").value("Corolla"))
                .andExpect(jsonPath("$[0].marca").value("Toyota"));

    }

    @Test
    void delete_deveRetornar204() throws Exception {
        // não precisa dizer nada no mock para void
        mockMvc.perform(delete("/veiculos/1"))
                .andExpect(status().isNoContent());

        then(veiculoService).should().deleteVeiculo(1L);
    }

    @Test
    void read() throws Exception{

        VeiculoResponse resp = new VeiculoResponse(1L,
                "Civic", "Honda", Funcao.PASSEIO, 2022);

        given(veiculoService.readVeiculo(1L)).willReturn(resp);

        mockMvc.perform(get("/veiculos/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelo").value("Civic"))
                .andExpect(jsonPath("$.marca").value("Honda"));
    }
}