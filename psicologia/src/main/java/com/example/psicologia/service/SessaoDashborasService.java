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

    public Integer totalSessoesMes(){
        Integer count = 0 ;
        LocalDate l = LocalDate.now();
        List<Sessao>  sessao =  sessaoRepository.findAll();
        for (Sessao s:
                sessao) {
            for (Status status:
                    s.getStatus()) {
                 Integer ano =   s.getDataAgendamento().getYear();
                if(status.getNome().equals("agendado") &&
                        s.getDataAgendamento().getMonth().equals(l.getMonth()) &&
                        s.getDataAgendamento().getYear() == ano
                ){
                    count++;
                }
            }
        }
        return count;
    }

    public Integer totalSessoesMesCanceladas(){
        Integer count = 0 ;
        LocalDate l = LocalDate.now();
        List<Sessao>  sessao =  sessaoRepository.findAll();
        for (Sessao s:
                sessao) {
            for (Status status:
                    s.getStatus()) {
                Integer ano =   s.getDataAgendamento().getYear();
                if(status.getNome().equals("cancelado") &&
                        s.getDataAgendamento().getMonth().equals(l.getMonth()) &&
                        s.getDataAgendamento().getYear() == ano
                ){
                    count++;
                }
            }
        }
        return count;
    }

    public Integer totalsessoesindividual(){
        Integer count = 0 ;

        List<Sessao>  sessao =  sessaoRepository.findAll();
        for (Sessao s:
                sessao) {
           if(s.getTipoSessao().getNome().equals("individual")){
               count++;
           }
        }
        return count;
    }
    public Integer totalsessoesdupla(){
        Integer count = 0 ;

        List<Sessao>  sessao =  sessaoRepository.findAll();
        for (Sessao s:
                sessao) {
            if(s.getTipoSessao().getNome().equals("dupla")){
                count++;
            }
        }
        return count;
    }
    public Integer totalsessoesgrupo(){
        Integer count = 0 ;

        List<Sessao>  sessao =  sessaoRepository.findAll();
        for (Sessao s:
                sessao) {
            if(s.getTipoSessao().getNome().equals("grupo")){
                count++;
            }
        }
        return count;
    }
}


