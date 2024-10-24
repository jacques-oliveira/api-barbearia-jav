package com.barbearia.api.controllers;

import com.barbearia.api.model.Agendamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @GetMapping
    public ResponseEntity<String> Get(){
        return ResponseEntity.ok("Bem vindo!");
    }
}
