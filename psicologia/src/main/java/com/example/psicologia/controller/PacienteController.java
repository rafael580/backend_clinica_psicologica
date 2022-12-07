package com.example.psicologia.controller;

import com.example.psicologia.entity.Paciente;
import com.example.psicologia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    public PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> todos(){
        return ResponseEntity.ok().body(pacienteService.todos());
    }

}
