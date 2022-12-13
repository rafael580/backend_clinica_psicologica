package com.example.psicologia.controller;

import com.example.psicologia.entity.Usuario;
import com.example.psicologia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{senha}")
    public ResponseEntity<Usuario> loginSEnha(String senha){
        return ResponseEntity.ok().body(usuarioService.login(senha));
    }

}
