package com.example.xyz.dao;

import com.example.xyz.entity.Veiculo;

public class VeiculoRequest {

    private Long id;

    public VeiculoRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
