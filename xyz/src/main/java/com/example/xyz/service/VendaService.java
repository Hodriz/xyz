package com.example.xyz.service;

import com.example.xyz.dto.VendaRequest;
import com.example.xyz.dto.VendaResponse;
import com.example.xyz.entity.Venda;
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

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda toEntity(VendaRequest vendaRequest) {
        Venda venda = new Venda(
                null,
                vendaRequest.getPessoa(),
                vendaRequest.getVeiculo(),
                LocalDateTime.now(),  // date
                vendaRequest.getValor()
        );

          return venda;
      }

      public VendaResponse toRespose(Venda venda){
            return new VendaResponse(
                    venda.getPessoa(),
                    venda.getVeiculo(),
                    null,
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
        Venda vendaFound=vendaRepository.findById(id).orElseThrow(()->new RuntimeException("Venda não encontrada!"));
        vendaFound.setVeiculo(vendaRequest.getVeiculo());
        vendaFound.setPessoa(vendaRequest.getPessoa());
        vendaFound.setValor(vendaRequest.getValor());

        Venda vendaUpdated=vendaRepository.save(vendaFound);
        return toRespose(vendaUpdated);
      }

      public void deleteVenda(Long id){
        Venda vendaFound=vendaRepository.findById(id).orElseThrow(()->new RuntimeException("Venda não encontrada!"));
        vendaRepository.delete(vendaFound);
      }
    }


