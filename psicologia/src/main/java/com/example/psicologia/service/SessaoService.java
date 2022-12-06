package com.example.psicologia.service;

import com.example.psicologia.entity.Sessao;
import com.example.psicologia.repository.SessaoRepository;
import com.example.psicologia.repository.StatusRepository;
import com.example.psicologia.repository.TipoSessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {


    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TipoSessaoRepository tipoSessaoRepository;


    public List<Sessao> todasSessoes(){
        return sessaoRepository.findAll();
    }




}
