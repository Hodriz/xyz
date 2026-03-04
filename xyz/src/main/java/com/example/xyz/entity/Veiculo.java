package com.example.xyz.entity;

import jakarta.persistence.*;


@Entity
@Table(name="veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String marca;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    private int lugares;
    private int ano;

    public Veiculo(String modelo, String marca, Funcao funcao, int lugares, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.funcao = funcao;
        this.lugares = lugares;
        this.ano = ano;
    }

    public Veiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
