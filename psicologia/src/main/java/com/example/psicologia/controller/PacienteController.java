package com.example.psicologia.controller;

import com.example.psicologia.entity.Paciente;
import com.example.psicologia.repository.PacienteRepository;
import com.example.psicologia.repository.filter.PacienteFilter;
import com.example.psicologia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public  ResponseEntity<Page<Paciente>> todos(PacienteFilter pacienteFilter, Pageable pageable){
        return ResponseEntity.ok().body( pacienteRepository.filtar(pacienteFilter,pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> pegarUmPaciente(@PathVariable Long id){
        return ResponseEntity.ok().body(pacienteService.pegarUm(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> criarUmPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok().body(pacienteService.criarPaciente(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarUmPaciente(@PathVariable Long id,@RequestBody Paciente paciente){
        return ResponseEntity.ok().body(pacienteService.atualizarUmPaciente(id,paciente));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable   Long id){
        pacienteService.deletarPaciente(id);
        return  ResponseEntity.noContent().build();
    }
}
