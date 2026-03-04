package com.example.xyz.repository;

import com.example.xyz.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{
}
