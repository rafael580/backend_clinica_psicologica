package com.example.psicologia.service;

import com.example.psicologia.entity.Sessao;
import com.example.psicologia.entity.Status;
import com.example.psicologia.entity.TipoSessao;
import com.example.psicologia.repository.SessaoRepository;
import com.example.psicologia.repository.StatusRepository;
import com.example.psicologia.repository.TipoSessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public Sessao pegarUmaSessao(Long id){
        Optional<Sessao> ses = sessaoRepository.findById(id);
        return ses.orElse(null);
    }
    public Sessao criarSessao(Sessao  sessao){
        Optional<Status> status = statusRepository.findById(1L);
        sessao.getStatus().clear();
        sessao.addStatus(status.orElse(null));
        return sessaoRepository.save(sessao);
    }

    public Sessao atualizarSessao(Long id,Sessao sessao){
        // pegando status do banco de dados
        Optional<Status> status = statusRepository.findById(1L);
        // pegando tipo da sessao do banco de dados
        Optional<TipoSessao> tipoSessao = tipoSessaoRepository.findById(sessao.getTipoSessao().getId());
        TipoSessao tipoSessao1 = tipoSessao.orElse(null);
        // buscando sessao pelo id
        Optional<Sessao> sessao1 = sessaoRepository.findById(id);
        Sessao sessao2 = sessao1.orElse(null);
        sessao2.setDataAgendamento(sessao.getDataAgendamento());
        sessao2.setDescricao(sessao.getDescricao());
        sessao2.setTemaSessao(sessao.getTemaSessao());
        sessao2.setDuracao(sessao.getDuracao());
        sessao2.setTipoSessao(tipoSessao1);
        sessao2.getStatus().clear();

        Set<Status> statusSet = new HashSet<>();
        statusSet.add(status.orElse(null));
        sessao2.setStatus(statusSet);
        return sessaoRepository.save(sessao2);
    }

    public Sessao atualizarStatusDaSessao(Long id,String descricao,Long idStatus){
        Optional<Status> status = statusRepository.findById(4L);
        Optional<Sessao> sessao1 = sessaoRepository.findById(id);
        Sessao sessao2 = sessao1.orElse(null);
        sessao2.setDescricao(descricao);
        sessao2.getStatus().clear();
        sessao2.addStatus(status.orElse(null));
        return sessaoRepository.save(sessao2);
    }

    public void deletarSessao(Long id){
        sessaoRepository.deleteById(id);
    }

}
