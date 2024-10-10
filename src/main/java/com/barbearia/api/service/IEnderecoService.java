package com.barbearia.api.service;

import com.barbearia.api.model.Endereco;
import java.util.List;

public interface IEnderecoService {
    List<Endereco> findAll();
    Endereco findById(Long id);
    Endereco create(Endereco endereco);
    boolean delete(Long id);
}
