package com.example.xyz.dto;

import com.example.xyz.entity.Pessoa;
import com.example.xyz.entity.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendaRequest {

    private Long idPessoa;
    private Long idVeiculo;
    private LocalDateTime date;
    private BigDecimal valor;

    public VendaRequest(Long idPessoa, Long idVeiculo, LocalDateTime date, BigDecimal valor) {
        this.idPessoa = idPessoa;
        this.idVeiculo = idVeiculo;
        this.date = date;
        this.valor = valor;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
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