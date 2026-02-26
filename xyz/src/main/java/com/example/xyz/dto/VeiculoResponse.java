package com.example.xyz.dto;

import com.example.xyz.entity.Funcao;
import com.example.xyz.entity.Veiculo;

public class VeiculoResponse {


    private String modelo;
    private String marca;
    private Funcao funcao;
    private int ano;

    public VeiculoResponse() {
    }

    public VeiculoResponse(String modelo, String marca, Funcao funcao, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.funcao = funcao;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public int getAno() {
        return ano;
    }
}
