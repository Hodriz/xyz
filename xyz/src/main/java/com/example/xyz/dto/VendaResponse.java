package com.example.xyz.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class VendaResponse {

    private Long IdPessoa;
    private Long IdVeiculo;
    private LocalDateTime date;
    private BigDecimal valor;


    public VendaResponse(Long idPessoa, Long idVeiculo, LocalDateTime date, BigDecimal valor) {
        IdPessoa = idPessoa;
        IdVeiculo = idVeiculo;
        this.date = date;
        this.valor = valor;
    }

    public Long getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        IdPessoa = idPessoa;
    }

    public Long getIdVeiculo() {
        return IdVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        IdVeiculo = idVeiculo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
