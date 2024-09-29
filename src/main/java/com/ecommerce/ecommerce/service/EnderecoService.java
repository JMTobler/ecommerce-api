package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.model.exception.ResourceBadRequestException;
import com.ecommerce.ecommerce.model.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionar(Endereco endereco) {
        if(endereco.getCep().equals("")){
            throw new ResourceBadRequestException("O cep do endereco é Obrigatorio");
        }
        
        endereco.setId((long) 0);

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> obterPorId(long id){
        Optional<Endereco> enderecoLocalizada = enderecoRepository.findById(id);

        if(enderecoLocalizada.isEmpty()){
            throw new ResourceNotFoundException("Nao foi possivel encontrar um endereco com o id: " + id);
        }

        return enderecoLocalizada;
    }

    public Endereco atualizar(Long id, Endereco endereco){
        obterPorId(id);
        endereco.setId(id);

        if(endereco.getCep().equals("")){
            throw new ResourceBadRequestException("O cep do endereco é Obrigatorio");
        }

        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id){
        obterPorId(id);

        enderecoRepository.deleteById(id);
    }

}
