package com.barbearia.api.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private int nivelAcesso;

    @OneToMany(mappedBy = "usuario")
    private Set<Agendamento> agendamentos;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Set<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

}
