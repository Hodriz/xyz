package com.example.xyz.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Integer age;

    public Pessoa(Long id, String name, String cpf, Integer age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public Pessoa() {
    }

    public Pessoa(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
