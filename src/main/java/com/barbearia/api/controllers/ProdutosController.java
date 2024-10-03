package com.barbearia.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosController {
    @GetMapping
    public String Get(){
        return "Todos Produtos";
    }
}
