package com.barbearia.api.service;

import com.barbearia.api.Repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository _agendamentoRepositoy;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        _agendamentoRepositoy = agendamentoRepository;
    }
}
