package com.example.xyz.service;

import com.example.xyz.dto.PessoaRequest;
import com.example.xyz.dto.PessoaResponse;
import com.example.xyz.entity.Pessoa;
import com.example.xyz.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;
    @InjectMocks
    private PessoaService pessoaService;

    private Pessoa pessoa;

    private PessoaRequest pessoaRequest;

    @BeforeEach
    void setUp() {
        pessoa=new Pessoa();
        pessoa.setAge(35);
        pessoa.setCpf("0648121963");
        pessoa.setName("José Batista");
        pessoa.setId(1L);

        pessoaRequest=new PessoaRequest("José Batista","0648121963",35);
    }

    @Test
    void createPessoa() {

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);
        PessoaResponse pessoaResponse=pessoaService.createPessoa(pessoaRequest);

        assertNotNull(pessoaResponse);
        assertEquals("José Batista",pessoaResponse.getName());
    }

    @Test
    void readPessoa() {

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        PessoaResponse pessoaResponse=pessoaService.readPessoa(1L);

        assertNotNull(pessoaResponse);
        assertEquals(35,pessoaResponse.getAge());
    }

    @Test
    void readAllPessoa() {

        when(pessoaRepository.findAll()).thenReturn(List.of(pessoa));
        List<PessoaResponse>list=pessoaService.readAllPessoa();
        assertEquals(1,list.size());
    }

    @Test
    void updatePessoa() {
        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        PessoaResponse pessoaResponse=pessoaService.updatePessoa(1L,pessoaRequest);
        assertEquals("José Batista",pessoaResponse.getName());
    }

    @Test
    void delete() {

        pessoa=new Pessoa(1L,"Silvio Santos","0645846531",78);

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        pessoaService.delete(1L);
        verify(pessoaRepository).delete(pessoa);
    }


}