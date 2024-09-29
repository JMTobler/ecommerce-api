package com.ecommerce.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.service.ClienteService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
        var clienteCriada = clienteService.adicionar(cliente);

        return new ResponseEntity<>(clienteCriada, HttpStatus.CREATED);
    }

    @GetMapping 
    public ResponseEntity<List<Cliente>> obterTodos() {
        return ResponseEntity.ok(clienteService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(clienteService.obterPorId(id));
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable long id, @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        clienteService.deletar(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
