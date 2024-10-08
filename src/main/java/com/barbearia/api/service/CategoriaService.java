package com.barbearia.api.service;

import com.barbearia.api.Repository.CategoriaRepository;
import com.barbearia.api.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    private CategoriaRepository _categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this._categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria findById(Long id) {
        Optional<Categoria> categoriaOptional = _categoriaRepository.findById(id);
        Categoria categoria = categoriaOptional.get();
        if(categoriaOptional.isPresent()){

            return categoria;
        }
        return null;
    }

    @Override
    public List<Categoria> findAll() {
        return _categoriaRepository.findAll();
    }

    @Override
    public Categoria create(Categoria categoria) {
        Optional<Categoria> categoriaOptional = _categoriaRepository.findById(categoria.getId());
        if (!categoriaOptional.isPresent()){
            _categoriaRepository.save(categoria);
            return categoria;
        }
        return null;
    }
    @Override
    public boolean delete(Long id){
        Optional<Categoria> categoriaBd = _categoriaRepository.findById(id);
        if(categoriaBd.isPresent()){
            Categoria categoria = categoriaBd.get();
            _categoriaRepository.delete(categoria);
            return true;
        }
        return false;
    }
}
