package com.ecommerce.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        var produtoCriada = produtoService.adicionar(produto);

        return new ResponseEntity<>(produtoCriada, HttpStatus.CREATED);
    }

    @GetMapping 
    public ResponseEntity<List<Produto>> obterTodos() {
        return ResponseEntity.ok(produtoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(produtoService.obterPorId(id));
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Produto>> getByCategoria(@PathVariable Long categoriaId) {
        List<Produto> produtos = produtoService.findByCategoria(categoriaId);
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        produtoService.deletar(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
