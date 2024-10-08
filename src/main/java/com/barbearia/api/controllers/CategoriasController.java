package com.barbearia.api.controllers;

import com.barbearia.api.Repository.CategoriaRepository;
import com.barbearia.api.model.Categoria;
import com.barbearia.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriaService _categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obterTodasCategorias(){
        List<Categoria> categorias = _categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(Categoria categoria){
        try{
            if(categoria != null){
                Categoria novaCategoria = _categoriaService.create(categoria);
                return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            if(_categoriaService.delete(id)){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
