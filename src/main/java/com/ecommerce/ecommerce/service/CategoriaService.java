package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.exception.ResourceBadRequestException;
import com.ecommerce.ecommerce.model.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria) {
        if(categoria.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da categoria é Obrigatprio");
        }
        
        categoria.setId((long) 0);

        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterPorId(long id){
        Optional<Categoria> categoriaLocalizada = categoriaRepository.findById(id);

        if(categoriaLocalizada.isEmpty()){
            throw new ResourceNotFoundException("Nao fio possivel encontrar uma categoria com o id: " + id);
        }

        return categoriaLocalizada;
    }

    public Categoria atualizar(Long id, Categoria categoria){
        obterPorId(id);
        categoria.setId(id);

        if(categoria.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da categoria é Obrigatprio");
        }

        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        obterPorId(id);

        categoriaRepository.deleteById(id);
    }

}
