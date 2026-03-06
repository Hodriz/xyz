package com.example.xyz.dto;

import com.example.xyz.entity.Pessoa;
import com.example.xyz.entity.Veiculo;

import java.math.BigDecimal;
import java.util.Date;

public class VendaResponse {

    private Pessoa pessoa;
    private Veiculo veiculo;
    private Date date;
    private BigDecimal valor;

    public VendaResponse(Pessoa pessoa, Veiculo veiculo, Date date, BigDecimal valor) {
        this.pessoa = pessoa;
        this.veiculo = veiculo;
        this.date = date;
        this.valor = valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
