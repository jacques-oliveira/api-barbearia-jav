package com.barbearia.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoriaid", nullable = false)
    @Schema(description = "ID da categoria associada")
    private Categoria categoria;

    @ManyToMany(mappedBy = "produtos")
    private Set<Agendamento> agendamentos;

    public Produto(){}

    public Set<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Produto(long id, String nome, String descricao, double preco, String imagemUrl) {
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

    public @NotNull Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull Categoria categoria) {
        this.categoria = categoria;
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
