package com.barbearia.api.controllers;

import com.barbearia.api.model.Contato;
import com.barbearia.api.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> Get(){
        var todosContatos =  contatoService.findAll();
        return ResponseEntity.ok(todosContatos);
    }
}
