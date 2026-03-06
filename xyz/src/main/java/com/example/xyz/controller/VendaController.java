package com.example.xyz.controller;

import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.dto.VendaRequest;
import com.example.xyz.dto.VendaResponse;
import com.example.xyz.repository.VendaRepository;
import com.example.xyz.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaResponse>create(@RequestBody VendaRequest vendaRequest){
        return ResponseEntity.ok(vendaService.createVenda(vendaRequest));
    }
    @GetMapping ("/{id}")
    public ResponseEntity<VendaResponse>read(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.readVenda(id));
    }

    @GetMapping
    public List<VendaResponse>readAll(){
        return vendaService.readAllVenda();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaResponse>vendaUpdate(@PathVariable Long id, @RequestBody VendaRequest vendaRequest ){
        return ResponseEntity.ok(vendaService.updateVenda(id,vendaRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        vendaService.deleteVenda(id);
        return ResponseEntity.noContent().build();
    }
}
