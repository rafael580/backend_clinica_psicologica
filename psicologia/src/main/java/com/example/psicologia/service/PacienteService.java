package com.example.psicologia.service;

import com.example.psicologia.entity.Paciente;
import com.example.psicologia.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository  pacienteRepository;

    public List<Paciente> todos(){
        return pacienteRepository.findAll();
    }

    public Paciente pegarUm(Long id){

        return null;
    }

    public void deletarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }


}
