package com.barbearia.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {
    @GetMapping(value = "/")
    public String paginaDefault(){
        return "Bem vindo api com spring boot!";
    }
}
