package com.barbearia.api.service;

import com.barbearia.api.model.Produto;
import java.util.List;

public interface IProdutoService {
    Produto findById(Long id);
    List<Produto> findAll();
    Produto create(Produto produto);
}
