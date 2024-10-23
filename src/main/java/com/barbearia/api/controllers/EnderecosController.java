package com.barbearia.api.controllers;

import com.barbearia.api.model.Endereco;
import com.barbearia.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {
    @Autowired
    private EnderecoService _enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> Get(){
        var todosEnderecos =  _enderecoService.findAll();
        return ResponseEntity.ok(todosEnderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> Get(@PathVariable Long id){
        try
        {
            Endereco endereco = _enderecoService.findById(id);
            if(endereco != null){
                return ResponseEntity.ok(endereco);
            }else{
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco){
        try{
            Endereco novoEndereco = _enderecoService.create(endereco);
            if (endereco == null) {
                return ResponseEntity.status(HttpStatus.FOUND).body(endereco);
            }else {
                return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
            }

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
