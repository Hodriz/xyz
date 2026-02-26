package com.example.xyz.service;

import com.example.xyz.dto.VeiculoRequest;
import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.entity.Veiculo;

public class VeiculoService {

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
}
