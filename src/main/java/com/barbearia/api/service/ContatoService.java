package com.barbearia.api.service;

import com.barbearia.api.model.Contato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService implements IContatoService{
    @Override
    public List<Contato> findAll() {
        return List.of();
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
