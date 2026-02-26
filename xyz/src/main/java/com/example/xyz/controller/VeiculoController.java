package com.example.xyz.controller;

import com.example.xyz.dto.VeiculoRequest;
import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @RequestMapping("/autos")
    @PostMapping
    public ResponseEntity<VeiculoResponse> criar(@RequestBody VeiculoRequest request){
        return ResponseEntity.ok(service.createVeiculo(request));
    }

}
