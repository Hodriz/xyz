package com.example.xyz.service;

import com.example.xyz.dto.VendaRequest;
import com.example.xyz.dto.VendaResponse;
import com.example.xyz.entity.Pessoa;
import com.example.xyz.entity.Veiculo;
import com.example.xyz.entity.Venda;
import com.example.xyz.repository.PessoaRepository;
import com.example.xyz.repository.VeiculoRepository;
import com.example.xyz.repository.VendaRepository;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final PessoaRepository pessoaRepository;
    private final VeiculoRepository veiculoRepository;

    public VendaService(VendaRepository vendaRepository, PessoaRepository pessoaRepository, VeiculoRepository veiculoRepository) {
        this.vendaRepository = vendaRepository;
        this.pessoaRepository = pessoaRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public Venda toEntity(VendaRequest vendaRequest) {
        Pessoa pessoa = pessoaRepository
                .findById(vendaRequest.getIdPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Veiculo veiculo = veiculoRepository
                .findById(vendaRequest.getIdVeiculo())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        Venda venda = new Venda(
                null,
                pessoa,
                veiculo,
                LocalDateTime.now(),
                vendaRequest.getValor()
        );

        return venda;
      }

      public VendaResponse toRespose(Venda venda){
            return new VendaResponse(
                    venda.getPessoa().getId(),
                    venda.getVeiculo().getId(),
                    venda.getDate(),
                    venda.getValor()
            );
      }

      public VendaResponse createVenda(VendaRequest vendaRequest){
         Venda venda=toEntity(vendaRequest);
         Venda vendaSalva=vendaRepository.save(venda);
         return toRespose(vendaSalva);
      }

      public VendaResponse readVenda(Long id){
         Venda vendaFound=vendaRepository.findById(id).orElseThrow(()->new RuntimeException("Venda não encontrada"));
         return toRespose(vendaFound);
      }

      public List<VendaResponse> readAllVenda(){
        List<Venda>listaVenda=vendaRepository.findAll();
        ArrayList<VendaResponse>listaResponse=new ArrayList<>();
          for(Venda v:listaVenda){
            listaResponse.add(toRespose(v));
        }
          return listaResponse;
      }

      public VendaResponse updateVenda(Long id, VendaRequest vendaRequest){
          Venda vendaFound = vendaRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));

          Pessoa pessoa = pessoaRepository.findById(vendaRequest.getIdPessoa())
                  .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

          Veiculo veiculo = veiculoRepository.findById(vendaRequest.getIdVeiculo())
                  .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));

          vendaFound.setPessoa(pessoa);
          vendaFound.setVeiculo(veiculo);
          vendaFound.setValor(vendaRequest.getValor());

          Venda vendaUpdated = vendaRepository.save(vendaFound);

          return toRespose(vendaUpdated);
      }

      public void deleteVenda(Long id){
        Venda vendaFound=vendaRepository.findById(id).orElseThrow(()->new RuntimeException("Venda não encontrada!"));
        vendaRepository.delete(vendaFound);
      }
    }


