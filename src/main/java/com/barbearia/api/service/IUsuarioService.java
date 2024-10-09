package com.barbearia.api.service;

import com.barbearia.api.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario create(Usuario usuario);
    boolean delete(Long id);
}
