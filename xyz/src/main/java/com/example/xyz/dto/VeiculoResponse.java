package com.example.xyz.dto;

import com.example.xyz.entity.Funcao;
import com.example.xyz.entity.Veiculo;

public class VeiculoResponse {

    private String modelo;
    private String marca;
    private Funcao funcao;
    private Integer ano;
    private Long id;

    public VeiculoResponse() {
    }

    public VeiculoResponse(Long id,String modelo, String marca, Funcao funcao, Integer ano) {
        this.id =id;
        this.modelo = modelo;
        this.marca = marca;
        this.funcao = funcao;
        this.ano = ano;
    }

    public Long getId() { return id;}

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public Integer getAno() {
        return ano;
    }
}
