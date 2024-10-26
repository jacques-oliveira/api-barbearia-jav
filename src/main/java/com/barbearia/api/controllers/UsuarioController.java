package com.barbearia.api.controllers;

import com.barbearia.api.model.Usuario;
import com.barbearia.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> obterTodosUsuarios(){
        try{
            var todosUsuarios =  usuarioService.findAll();
            return ResponseEntity.ok(todosUsuarios);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        try{
            Usuario novoUsuario = usuarioService.create(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            boolean usuarioDeletado = usuarioService.delete(id);
            if (usuarioDeletado){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado com sucesso");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario n�o encontrado!");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
