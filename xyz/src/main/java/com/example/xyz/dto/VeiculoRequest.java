package com.example.xyz.dto;

import com.example.xyz.entity.Funcao;

public class VeiculoRequest {

    private String modelo;
    private String marca;
    private Funcao funcao;
    private int ano;

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void setAno(int ano) {
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
