package com.example.xyz.controller;

import com.example.xyz.dto.PessoaRequest;
import com.example.xyz.dto.PessoaResponse;
import com.example.xyz.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController {


    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody PessoaRequest request){
        return ResponseEntity.ok(pessoaService.createPessoa(request));
    }

    @GetMapping("{/id}")
    public  ResponseEntity<PessoaResponse> read(@PathVariable Long id){
        return  ResponseEntity.ok(pessoaService.readPessoa(id));
    }

    @PutMapping("{/id}")
    public ResponseEntity<PessoaResponse>update(@PathVariable Long id, @RequestBody PessoaRequest request){
        return ResponseEntity.ok(pessoaService.updatePessoa(id, request));
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
