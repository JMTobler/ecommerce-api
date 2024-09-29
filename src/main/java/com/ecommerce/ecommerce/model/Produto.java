package com.ecommerce.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private double preco;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
