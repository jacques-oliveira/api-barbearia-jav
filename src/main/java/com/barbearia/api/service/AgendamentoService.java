package com.barbearia.api.service;

import com.barbearia.api.Repository.AgendamentoRepository;
import com.barbearia.api.model.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService implements {
    @Autowired
    private AgendamentoRepository _agendamentoRepositoy;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        _agendamentoRepositoy = agendamentoRepository;
    }

}
