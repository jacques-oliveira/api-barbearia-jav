package com.barbearia.api.service;

import com.barbearia.api.model.Contato;
import java.util.List;

public interface IContatoService {
    List<Contato> findAll();
    Contato findById(Long id);
    Contato create(Contato contato);
    boolean delete(Long id);
}
