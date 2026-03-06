package com.example.xyz.dto;

import com.example.xyz.entity.Pessoa;
import com.example.xyz.entity.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendaRequest {

    private Pessoa pessoa;
    private Veiculo veiculo;
    private LocalDateTime date;
    private BigDecimal valor;

    public VendaRequest(Pessoa pessoa, Veiculo veiculo, LocalDateTime date, BigDecimal valor) {
        this.pessoa = pessoa;
        this.veiculo = veiculo;
        this.date = date;
        this.valor = valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
