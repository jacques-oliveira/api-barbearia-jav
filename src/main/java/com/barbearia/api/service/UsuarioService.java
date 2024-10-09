package com.barbearia.api.service;

import com.barbearia.api.Repository.UsuarioRepository;
import com.barbearia.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository _usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this._usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> usuarioBd = _usuarioRepository.findById(id);
        if(usuarioBd.isPresent()){
            Usuario usuario = usuarioBd.get();
            return usuario;
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return _usuarioRepository.findAll();
    }

    @Override
    public Usuario create(Usuario usuario) {
        Optional<Usuario> usuarioBd = _usuarioRepository.findById(usuario.getId());
        if(!usuarioBd.isPresent()){
            _usuarioRepository.save(usuario);
            return usuario;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
