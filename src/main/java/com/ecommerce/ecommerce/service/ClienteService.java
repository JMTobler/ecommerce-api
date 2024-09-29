package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.model.exception.ResourceBadRequestException;
import com.ecommerce.ecommerce.model.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente) {
        if(cliente.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do cliente é Obrigatorio");
        }
        
        cliente.setId((long) 0);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterPorId(long id){
        Optional<Cliente> clienteLocalizada = clienteRepository.findById(id);

        if(clienteLocalizada.isEmpty()){
            throw new ResourceNotFoundException("Nao foi possivel encontrar um cliente com o id: " + id);
        }

        return clienteLocalizada;
    }

    public Cliente atualizar(Long id, Cliente cliente){
        obterPorId(id);
        cliente.setId(id);

        if(cliente.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do cliente é Obrigatorio");
        }

        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        obterPorId(id);

        clienteRepository.deleteById(id);
    }

}
