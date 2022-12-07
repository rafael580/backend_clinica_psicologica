package com.example.psicologia.service;

import com.example.psicologia.entity.Genero;
import com.example.psicologia.entity.Paciente;
import com.example.psicologia.repository.GeneroRepository;
import com.example.psicologia.repository.PacienteRepository;
import com.example.psicologia.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository  pacienteRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public List<Paciente> todos(){
        return pacienteRepository.findAll();
    }

    public Paciente pegarUm(Long id){
        return null;
    }

    public Paciente criarPaciente(Paciente paciente){
        Optional<Genero> genero = generoRepository.findById(paciente.getGenero().getId());
        paciente.setGenero(genero.orElseThrow(()-> new ResourceNotFoundException("Genero not found")));
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarUmPaciente(Long id, Paciente paciente){
        Optional<Paciente> paciente1  = pacienteRepository.findById(id);
        Paciente paciente2 = paciente1.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
        Optional<Genero> genero = generoRepository.findById(paciente.getGenero().getId());
        paciente2.setGenero(genero.orElseThrow(()-> new ResourceNotFoundException("Genero not found")));
        paciente2.setCidade(paciente.getCidade());
        paciente2.setCpf(paciente.getCpf());
        paciente2.setEmail(paciente.getEmail());
        paciente2.setDataNascimento(paciente.getDataNascimento());
        paciente2.setNome(paciente.getNome());
        paciente2.setEndereco(paciente.getEndereco());
        paciente2.setEstado(paciente.getEstado());
        paciente2.setTelefone(paciente.getTelefone());

        return pacienteRepository.save(paciente2);
    }

    public void deletarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
