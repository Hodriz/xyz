package com.example.xyz.service;

import com.example.xyz.dto.PessoaRequest;
import com.example.xyz.dto.PessoaResponse;
import com.example.xyz.entity.Pessoa;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa toEntity(PessoaRequest pessoaRequest){
        return new Pessoa(
                pessoaRequest.getName(),
                pessoaRequest.getCpf(),
                pessoaRequest.getAge());

    }

    public PessoaResponse toResponse(Pessoa pess){
        return new PessoaResponse(
                pess.getId(),
                pess.getName(),
                pess.getAge());
    }

    public PessoaResponse createPessoa(PessoaRequest pessoaRequest){
        Pessoa pessoa=toEntity(pessoaRequest);
        Pessoa pessoaSave=pessoaRepository.save(pessoa);
        return toResponse(pessoaSave);
    }

    public PessoaResponse readPessoa(Long id){
        Pessoa pessoaFound=pessoaRepository.findById(id).orElseThrow(()->new RuntimeException("Pessoa não encontrada!"));
        pessoaFound.getId();
        pessoaFound.getAge();
        pessoaFound.getName();
        pessoaFound.getCpf();
        return toResponse(pessoaFound);
    }

    public List<PessoaResponse> readAllPessoa(){
        List<Pessoa> listPessoa=pessoaRepository.findAll();
        List<PessoaResponse>reponseList=new ArrayList<>();

        for(Pessoa pess: listPessoa){
            reponseList.add(toResponse(pess));
        } return reponseList;
    }

    public PessoaResponse updatePessoa(Long id, PessoaRequest pessoaRequest){
        Pessoa pessoaFound=pessoaRepository.findById(id).orElseThrow(()->new RuntimeException("Pessoa não encontrada!"));

        pessoaFound.setAge(pessoaRequest.getAge());
        pessoaFound.setName(pessoaRequest.getName());
        pessoaFound.setCpf(pessoaRequest.getCpf());

        Pessoa pessoaUpdated=pessoaRepository.save(pessoaFound);

        return toResponse(pessoaUpdated);
    }

    public void delete (Long id){
        Pessoa pessoaFound=pessoaRepository.findById(id).orElseThrow(()->new RuntimeException("Pessoa não encontrada!!"));
        pessoaRepository.delete(pessoaFound);
    }


}
