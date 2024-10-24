package com.barbearia.api.service;

import com.barbearia.api.model.Agendamento;
import java.util.List;

public interface IAgendamentoService {
    Agendamento findById(Long id);
    List<Agendamento> findAll();
    Agendamento create(Agendamento agendamento);
    boolean delete(Long id);
}
