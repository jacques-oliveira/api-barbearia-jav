package com.barbearia.api.service;

import com.barbearia.api.Repository.EnderecoRepository;
import com.barbearia.api.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

        Optional<Endereco> enderecoOptional = _enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()){
            var endereco = enderecoOptional.get();
            return endereco;
        }
        return  null;
    }

    @Override
    public Endereco create(Endereco endereco) {
        Optional<Endereco> enderecoOptional = _enderecoRepository.findById(endereco.getId());

        if (!enderecoOptional.isPresent()){
            _enderecoRepository.save(endereco);
            return endereco;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Endereco> enderecoBD = _enderecoRepository.findById(id);
        if(enderecoBD.isPresent()){
            Endereco endereco =enderecoBD.get();
            _enderecoRepository.delete(endereco);
            return true;
        }
        return false;
    }
}
