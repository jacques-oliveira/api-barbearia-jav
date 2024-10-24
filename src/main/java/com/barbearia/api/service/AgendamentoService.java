package com.barbearia.api.service;

import com.barbearia.api.Repository.AgendamentoRepository;
import com.barbearia.api.model.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService implements IAgendamentoService{
    @Autowired
    private AgendamentoRepository _agendamentoRepositoy;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        _agendamentoRepositoy = agendamentoRepository;
    }

    @Override
    public Agendamento findById(Long id) {
        return null;
    }

    @Override
    public List<Agendamento> findAll(){
        return _agendamentoRepositoy.findAll();
    }

    @Override
    public Agendamento create(Agendamento agendamento) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
