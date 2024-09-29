package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.model.exception.ResourceBadRequestException;
import com.ecommerce.ecommerce.model.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto) {
        if(produto.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do produto é Obrigatorio");
        }
        
        produto.setId((long) 0);

        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(long id){
        Optional<Produto> produtoLocalizada = produtoRepository.findById(id);

        if(produtoLocalizada.isEmpty()){
            throw new ResourceNotFoundException("Nao foi possivel encontrar um produto com o id: " + id);
        }

        return produtoLocalizada;
    }

    public List<Produto> findByCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }

    public Produto atualizar(Long id, Produto produto){
        obterPorId(id);
        produto.setId(id);

        if(produto.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do produto é Obrigatorio");
        }

        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        obterPorId(id);

        produtoRepository.deleteById(id);
    }

}
