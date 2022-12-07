package com.example.psicologia.service;

import com.example.psicologia.entity.Sessao;
import com.example.psicologia.entity.Status;
import com.example.psicologia.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SessaoDashborasService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public Integer totalDeSessoes(){
        List<Sessao>  sessao =  sessaoRepository.findAll();
        return sessao.size();
    }

    public Integer totalDeSessoesDia(){
        Integer count = 0 ;
        LocalDate l = LocalDate.now();
        List<Sessao>  sessao =  sessaoRepository.findAll();
        for (Sessao s:
             sessao) {
            for (Status status:
                 s.getStatus()) {
                if(status.getNome().equals("agendado") && s.getDataAgendamento().equals(l) ){
                   count++;
                }
            }
        }
        return count;
    }
}


