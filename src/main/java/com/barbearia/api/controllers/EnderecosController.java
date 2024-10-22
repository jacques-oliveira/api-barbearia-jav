package com.barbearia.api.controllers;

import com.barbearia.api.model.Endereco;
import com.barbearia.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {
    @Autowired
    private EnderecoService _enderecoService;

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
}
