package com.example.xyz.service;

import com.example.xyz.dto.VeiculoRequest;
import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.repository.VeiculoRepository;

public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo toEntity(VeiculoRequest req){
        Veiculo veiculo=new Veiculo();
        veiculo.setModelo(req.getModelo());
        veiculo.setAno(req.getAno());
        veiculo.setMarca(req.getMarca());
        veiculo.setFuncao(req.getFuncao());

        return veiculo;
    }

    public VeiculoResponse toResponse(Veiculo v){
        return new VeiculoResponse(
                v.getModelo(),
                v.getMarca(),
                v.getFuncao(),
                v.getAno()
        );
    }

    public VeiculoResponse createVeiculo(VeiculoRequest req){
        Veiculo veiculo=toEntity(req);
        Veiculo salvo=repository.save(veiculo);
        return toResponse(salvo);
    }
}
