package com.example.xyz.controller;

import com.example.xyz.dto.VeiculoRequest;
import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VeiculoResponse> criate(@RequestBody VeiculoRequest request){
        return ResponseEntity.ok(service.createVeiculo(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse>update(@PathVariable Long id, @RequestBody VeiculoRequest req){
        return  ResponseEntity.ok(service.updateVeiculo(id, req));
    }

    @GetMapping
    public List<VeiculoResponse> readAll() {
        return service.readAllVeiculo();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.deleteVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<VeiculoResponse>read(@PathVariable Long id){
        return ResponseEntity.ok(service.readVeiculo(id));
    }



}
