package com.barbearia.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Nome;
    private String descricao;
    private double preco;
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    public Produto(long id, String nome, String descricao, double preco, String imagemUrl, int categoriaId) {
        Id = id;
        Nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", imagemUrl='" + imagemUrl + '\'' +
                '}';
    }
}
