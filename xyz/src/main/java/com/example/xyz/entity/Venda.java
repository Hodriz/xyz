package com.example.xyz.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name="venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    @DateTimeFormat
    private LocalDateTime date;
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    public Venda(Long id, Pessoa pessoa, Veiculo veiculo, LocalDateTime date, BigDecimal valor) {
        this.id = id;
        this.pessoa = pessoa;
        this.veiculo = veiculo;
        this.date = date;
        this.valor = valor;
    }

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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