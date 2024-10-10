package com.barbearia.api.service;

import com.barbearia.api.Repository.EnderecoRepository;
import com.barbearia.api.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements IEnderecoService{

    @Autowired
    private EnderecoRepository _enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this._enderecoRepository = enderecoRepository;
    }
    @Override
    public List<Endereco> findAll() {
        return _enderecoRepository.findAll();
    }

    @Override
    public Endereco findById(Long id) {
        return null;
    }

    @Override
    public Endereco create(Endereco endereco) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
