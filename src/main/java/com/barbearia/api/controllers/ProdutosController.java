package com.barbearia.api.controllers;

import com.barbearia.api.Repository.ProdutoRepository;
import com.barbearia.api.model.Produto;
import com.barbearia.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodosProdutos() {
        try{
            var produtos = produtoService.findAll();
            return ResponseEntity.ok(produtos);
        }catch (Exception ex){
            System.err.println("Erro ao recuperar produtos: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        try {
            Produto novoProduto = produtoService.create(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            boolean deleted = produtoService.delete(id);
            if(deleted){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
