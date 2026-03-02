package com.example.xyz.dto;

import com.example.xyz.entity.Funcao;

public class VeiculoRequest {

    private String modelo;
    private String marca;
    private Funcao funcao;
    private Integer lugares;
    private Integer ano;

    public VeiculoRequest(String modelo, String marca, Funcao funcao, Integer ano, Integer lugares) {
        this.modelo = modelo;
        this.marca = marca;
        this.funcao = funcao;
        this.ano = ano;
        this.lugares= lugares;
    }

    public VeiculoRequest() {
    }



    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void setAno(Integer ano) {
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

    public Integer getAno() {
        return ano;
    }

    public Integer getLugares() {
        return lugares;
    }

    public void setLugares(Integer lugares) {
        this.lugares = lugares;
    }
}
