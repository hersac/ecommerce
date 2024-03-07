package com.hersac.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UsuariosController {
    @GetMapping
    public String index(){
        return "Hello";
    }
}
