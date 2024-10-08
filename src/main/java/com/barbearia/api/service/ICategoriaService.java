package com.barbearia.api.service;

import com.barbearia.api.model.Categoria;
import java.util.List;

public interface ICategoriaService {
    Categoria findById(Long id);
    List<Categoria> findAll();
    Categoria create(Categoria categoria);
}
