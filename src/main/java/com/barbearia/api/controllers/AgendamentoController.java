package com.barbearia.api.controllers;

import com.barbearia.api.model.Agendamento;
import com.barbearia.api.model.Dtos.AgendamentoDto;
import com.barbearia.api.model.Produto;
import com.barbearia.api.service.AgendamentoService;
import com.barbearia.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Agendamento>> Get(){
        var todosAgendamentos =  agendamentoService.findAll();
        return ResponseEntity.ok(todosAgendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> obterAgendamentoPorId(@PathVariable Long id){
        try{
            Agendamento agendamento = agendamentoService.findById(id);
            return ResponseEntity.ok(agendamento);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody AgendamentoDto agendamentoDto){
        try {

            Set<Produto> listaProdutos = new HashSet<>();

            for(Long produtoId: agendamentoDto.getListaProdutos()){
                Produto produto = produtoService.findById(produtoId);
                if(produto == null){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                listaProdutos.add(produto);
            }

            Agendamento novoAgendamento = new Agendamento();
            novoAgendamento.setId(agendamentoDto.getUsuarioId());
            novoAgendamento.setData(agendamentoDto.getData());
            novoAgendamento.setProdutos(listaProdutos);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(novoAgendamento);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
