package com.example.xyz.service;

import com.example.xyz.dto.VendaRequest;
import com.example.xyz.dto.VendaResponse;
import com.example.xyz.entity.Funcao;
import com.example.xyz.entity.Pessoa;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.entity.Venda;
import com.example.xyz.repository.VendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VendaServiceTest {

    @Mock
    private VendaRepository vendaRepository;

    @InjectMocks
    private VendaService vendaService;

    private Venda venda;
    private Pessoa pessoa;
    private VendaRequest vendaRequest;
    private Veiculo veiculo;

    @BeforeEach
    void setUp() {

        pessoa=new Pessoa(
                1L,
                "Fausto Silva",
                "06458123659",
                51
        );

        venda=new Venda(
                1L,
                pessoa,
                new Veiculo(),
                LocalDateTime.now(),
                new BigDecimal("23500.23")
        );

        veiculo=new Veiculo(
                "Fiorino",
                "Fiat",
                Funcao.UTILITARIO,
                2,
                2010
        );



        vendaRequest = new VendaRequest(
                pessoa,
                veiculo,
                LocalDateTime.now(),
                new BigDecimal("23500.23")
        );


    }

    @Test
    void createVenda() {
        when(vendaRepository.save(any(Venda.class))).thenReturn(venda);

        VendaResponse vendaResponse=vendaService.createVenda(vendaRequest);
        assertEquals("Fausto Silva",vendaResponse.getPessoa().getName());
    }

    @Test
    void readVenda() {

    }

    @Test
    void readAllVenda() {
    }

    @Test
    void updateVenda() {
    }

    @Test
    void deleteVenda() {
    }
}