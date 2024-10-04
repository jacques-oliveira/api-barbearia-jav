package com.barbearia.api.controllers;

import com.barbearia.api.Repository.ProdutoRepository;
import com.barbearia.api.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    public @ResponseBody Iterable<Produto> obterTodosProdutos() {
        try{
            return produtoRepository.findAll();
        }catch (Exception ex){

        }
        return null;
    }
}
