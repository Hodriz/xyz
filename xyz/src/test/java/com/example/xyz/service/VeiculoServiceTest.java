package com.example.xyz.service;

import com.example.xyz.dto.VeiculoRequest;
import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.entity.Funcao;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.repository.VeiculoRepository;
import org.hibernate.boot.internal.Extends;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {

    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoService veiculoService;

    private Veiculo veiculo;
    private VeiculoRequest request;

    @BeforeEach
    void setUp() {
        veiculo=new Veiculo();
        veiculo.setId(1L);
        veiculo.setModelo("Corolla");
        veiculo.setAno(2012);
        veiculo.setLugares(5);
        veiculo.setMarca("Toyota");
        veiculo.setFuncao(Funcao.EXECUTIVO);

        request=new VeiculoRequest(
                "Corolla","Toyota",Funcao.EXECUTIVO,2012,5);
    }

    @Test
    void createVeiculo() {
        when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

        VeiculoResponse veiculoResponse=veiculoService.createVeiculo(request);

        assertNotNull(veiculoResponse);
        assertEquals("Corolla", veiculoResponse.getModelo());

        verify(veiculoRepository, times(1)).save(any(Veiculo.class));
    }

    @Test
    void updateVeiculo() {
        when(veiculoRepository.findById(1L))
                              .thenReturn(Optional.of(veiculo));

        when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

        VeiculoResponse response = veiculoService.updateVeiculo(1L, request);
        assertEquals("Corolla", response.getModelo());
    }

    @Test
    void readVeiculo() {
        when(veiculoRepository.findById(1L)).thenReturn(Optional.of(veiculo));
        VeiculoResponse veiculoResponse=veiculoService.readVeiculo(1L);

        assertEquals("Corolla", veiculoResponse.getModelo());
    }

    @Test
    void readAllVeiculo() {
        when(veiculoRepository.findAll()).thenReturn(List.of(veiculo));

        List<VeiculoResponse>veiculoList=veiculoService.readAllVeiculo();
        assertEquals(1,veiculoList.size());
    }

    @Test
    void deleteVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1L);

        when(veiculoRepository.findById(1L))
                .thenReturn(Optional.of(veiculo));

        veiculoService.deleteVeiculo(1L);

        verify(veiculoRepository).delete(veiculo);
    }
}