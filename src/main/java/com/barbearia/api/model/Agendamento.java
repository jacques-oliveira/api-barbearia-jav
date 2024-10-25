package com.barbearia.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Agendamento(Long id, LocalDateTime data, Usuario usuario, Set<Produto> produtos) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.produtos = produtos;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @ManyToMany
    @JoinTable(
            name = "agendamento_produto",
            joinColumns=@JoinColumn(name = "agendamento_id"),
            inverseJoinColumns = @JoinColumn(name ="produto_id")
    )
    private Set<Produto> produtos;

    public Agendamento(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
