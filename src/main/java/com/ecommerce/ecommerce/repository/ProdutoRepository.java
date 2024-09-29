package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaId(Long categoriaId);
}

