package com.example.psicologia.controller;

import com.example.psicologia.entity.Paciente;
import com.example.psicologia.repository.PacienteRepository;
import com.example.psicologia.repository.filter.PacienteFilter;
import com.example.psicologia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public Page<Paciente> todos(PacienteFilter pacienteFilter, Pageable pageable){
        return pacienteRepository.filtar(pacienteFilter,pageable);
    }

}
