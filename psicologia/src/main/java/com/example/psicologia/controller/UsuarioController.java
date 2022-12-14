package com.example.psicologia.controller;

import com.example.psicologia.entity.Usuario;
import com.example.psicologia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin("*")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{email}")
    public ResponseEntity<Usuario> pegarUser(@PathVariable String email){
        return ResponseEntity.ok().body(usuarioService.loginUsuario(email));
    }
}
