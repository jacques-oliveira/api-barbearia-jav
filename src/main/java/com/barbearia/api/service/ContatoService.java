package com.barbearia.api.service;

import com.barbearia.api.Repository.ContatoRepository;
import com.barbearia.api.model.Contato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService implements IContatoService{

    private ContatoRepository _contatoRepository;

    public ContatoService(ContatoRepository contatoRepository){
        this._contatoRepository = contatoRepository;
    }

    @Override
    public List<Contato> findAll() {
        return  _contatoRepository.findAll();
    }

    @Override
    public Contato findById(Long id) {
        return null;
    }

    @Override
    public Contato create(Contato contato) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
