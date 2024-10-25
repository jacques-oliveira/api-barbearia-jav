package com.barbearia.api.service;

import com.barbearia.api.Repository.AgendamentoRepository;
import com.barbearia.api.model.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService implements IAgendamentoService{
    @Autowired
    private AgendamentoRepository _agendamentoRepositoy;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        try{
            this._agendamentoRepositoy = agendamentoRepository;
        }catch (Exception ex){
            throw new RuntimeException("Falha ao buscar todos agendamentos",ex);
        }
    }

    @Override
    public Agendamento findById(Long id) {

        try {
            Optional<Agendamento> agendamentoOptional = _agendamentoRepositoy.findById(id);
            if(agendamentoOptional.isPresent()){
                return agendamentoOptional.get();
            }
            return null;
        }catch (Exception ex){
            throw new RuntimeException("Agendamento n�o encontrado", ex);
        }
    }

    @Override
    public List<Agendamento> findAll(){
        return _agendamentoRepositoy.findAll();
    }

    @Override
    public Agendamento create(Agendamento agendamento) {
        Optional<Agendamento> agendamentoOptional = _agendamentoRepositoy.findById(agendamento.getId());
        if (!agendamentoOptional.isPresent()){
            _agendamentoRepositoy.save(agendamento);
            return  agendamento;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try{
            Optional<Agendamento> agendamentoOptional = _agendamentoRepositoy.findById(id);
            if (agendamentoOptional.isPresent()){
                Agendamento agendamento = agendamentoOptional.get();
                _agendamentoRepositoy.delete(agendamento);
                return true;
            }
            return false;
        }catch (Exception ex){
            throw new RuntimeException("Falha na remoç�o do agendamento",ex);
        }
    }
}
