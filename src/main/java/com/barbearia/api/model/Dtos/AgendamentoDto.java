package com.barbearia.api.model.Dtos;

import com.barbearia.api.model.Agendamento;

import java.time.LocalDateTime;
import java.util.Set;

public class AgendamentoDto {
    private LocalDateTime data;
    private Long usuarioId;
    private Set<Long> listaProdutos;

    public AgendamentoDto(){}

    public AgendamentoDto(LocalDateTime data, Long usuarioId, Set<Long> listaProdutos) {
        this.data = data;
        this.usuarioId = usuarioId;
        this.listaProdutos = listaProdutos;
    }
    
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<Long> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(Set<Long> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
