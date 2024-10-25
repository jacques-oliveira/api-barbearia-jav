package com.barbearia.api.controllers;

import com.barbearia.api.model.Agendamento;
import com.barbearia.api.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<Agendamento>> Get(){
        var todosAgendamentos =  agendamentoService.findAll();
        return ResponseEntity.ok(todosAgendamentos);
    }

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento){
        try {
            Agendamento novoAgendamento = agendamentoService.create(agendamento);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(novoAgendamento);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
