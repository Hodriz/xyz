package com.example.xyz.service;

import com.example.xyz.dto.VeiculoRequest;
import com.example.xyz.dto.VeiculoResponse;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo toEntity(VeiculoRequest req){
        Veiculo veiculo=new Veiculo();
        veiculo.setModelo(req.getModelo());
        veiculo.setAno(req.getAno());
        veiculo.setMarca(req.getMarca());
        veiculo.setFuncao(req.getFuncao());
        veiculo.setLugares(req.getLugares());

        return veiculo;
    }

    public VeiculoResponse toResponse(Veiculo v){
        return new VeiculoResponse(
                v.getModelo(),
                v.getMarca(),
                v.getFuncao(),
                v.getAno()
        );
    }

    public VeiculoResponse createVeiculo(VeiculoRequest req){
        Veiculo veiculo=toEntity(req);
        Veiculo salvo=repository.save(veiculo);
        return toResponse(salvo);
    }

    public VeiculoResponse updateVeiculo(Long id, VeiculoRequest req){

        Veiculo veiculoFound=repository.findById(id).orElseThrow(
                ()->new RuntimeException("Veiculo não encontrado!"));

        veiculoFound.setMarca(req.getMarca());
        veiculoFound.setModelo(req.getModelo());
        veiculoFound.setAno(req.getAno());
        veiculoFound.setFuncao(req.getFuncao());
        veiculoFound.setLugares(req.getLugares());

        Veiculo veiculoUpdated=repository.save(veiculoFound);

        return toResponse(veiculoUpdated);
    }

    public  VeiculoResponse readVeiculo(Long id){

        Veiculo veiculoFound=repository.findById(id).orElseThrow(
                ()->new RuntimeException("Veiculo não encontrado"));
        veiculoFound.getModelo();
        veiculoFound.getFuncao();
        veiculoFound.getMarca();
        veiculoFound.getAno();
        veiculoFound.getLugares();

        return  toResponse(veiculoFound);
    }

    public  List<VeiculoResponse> readAllVeiculo(){

        List<Veiculo> veiculoListFound=repository.findAll();

        List<VeiculoResponse> responseList = new ArrayList<>();

        for (Veiculo v : veiculoListFound) {
            responseList.add(toResponse(v));
        }
        return responseList;
    }

    public void deleteVeiculo(Long id){
        Veiculo veiculoFound=repository.findById(id).orElseThrow(()->new RuntimeException("Veiculo não encontrado"));
        repository.delete(veiculoFound);
    }
}
