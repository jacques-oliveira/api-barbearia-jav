package com.barbearia.api.controllers;

import com.barbearia.api.Repository.ProdutoRepository;
import com.barbearia.api.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ProdutosController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    public ResponseEntity<List<Produto>> obterTodosProdutos() {
        try{
            var produtos = produtoRepository.findAll();
            return ResponseEntity.ok(produtos);
        }catch (Exception ex){
            System.err.println("Erro ao recuperar produtos: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Produto> Create(@RequestBody Produto produto){
        try {
            Produto novoProduto = produtoRepository.save(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
