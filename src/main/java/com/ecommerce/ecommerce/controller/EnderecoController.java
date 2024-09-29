package com.ecommerce.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Endereco;
import com.ecommerce.ecommerce.service.EnderecoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> adicionar(@RequestBody Endereco endereco) {
        var enderecoCriada = enderecoService.adicionar(endereco);

        return new ResponseEntity<>(enderecoCriada, HttpStatus.CREATED);
    }

    @GetMapping 
    public ResponseEntity<List<Endereco>> obterTodos() {
        return ResponseEntity.ok(enderecoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(enderecoService.obterPorId(id));
    }

    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable long id, @RequestBody Endereco endereco) {
        return enderecoService.atualizar(id, endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        enderecoService.deletar(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
