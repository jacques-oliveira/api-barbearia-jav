package com.barbearia.api.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "agendamento_produto",
            joinColumns=@JoinColumn(name = "agendamento_id"),
            inverseJoinColumns = @JoinColumn(name ="produto_id")
    )
    private Set<Produto> produtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Produto> getProduto() {
        return produtos;
    }

    public void setProduto(Set<Produto> produto) {
        this.produtos = produto;
    }
}
