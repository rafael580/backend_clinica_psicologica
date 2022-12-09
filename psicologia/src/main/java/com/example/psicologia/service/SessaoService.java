package com.example.psicologia.service;

import com.example.psicologia.dto.DescricaoUpdateDTO;
import com.example.psicologia.entity.Paciente;
import com.example.psicologia.entity.Sessao;
import com.example.psicologia.entity.Status;
import com.example.psicologia.entity.TipoSessao;
import com.example.psicologia.repository.PacienteRepository;
import com.example.psicologia.repository.SessaoRepository;
import com.example.psicologia.repository.StatusRepository;
import com.example.psicologia.repository.TipoSessaoRepository;
import com.example.psicologia.service.exception.DataBaseException;
import com.example.psicologia.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SessaoService {

    @Autowired
    private PacienteRepository pacienteRepository;

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
        return ses.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
    }
    public Sessao criarSessao(String cpf , Sessao  sessao){

        Paciente paciente = pacienteRepository.findByCpf(cpf);
        if(paciente==null){
            throw new ResourceNotFoundException("cpf Not exist");
        }
        Optional<Status> status = statusRepository.findById(1L);
        sessao.getStatus().clear();
        sessao.addStatus(status.orElseThrow(()-> new ResourceNotFoundException("Entity not found")));
        sessao = sessaoRepository.save(sessao);
        paciente.addSessao(sessao);
        pacienteRepository.save(paciente);
        return sessao;
    }

    public Sessao atualizarSessao(Long id,Sessao sessao){


        Paciente pacienteDaSessao = pacienteRepository.findByCpf("1");
        Paciente pacienteDestinoSessao = pacienteRepository.findByCpf("1");

        if(pacienteDaSessao==null){
            throw new ResourceNotFoundException("cpf of session Not exist");
        }
        if(pacienteDestinoSessao==null){
            throw new ResourceNotFoundException("cpf destino Not exist");
        }

        // pegando status do banco de dados
        Optional<Status> status = statusRepository.findById(1L);
        // pegando tipo da sessao do banco de dados
        Optional<TipoSessao> tipoSessao = tipoSessaoRepository.findById(sessao.getTipoSessao().getId());
        TipoSessao tipoSessao1 = tipoSessao.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
        // buscando sessao pelo id
        Optional<Sessao> sessao1 = sessaoRepository.findById(id);

        Sessao sessao2 = sessao1.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));

        sessao2.setDataAgendamento(sessao.getDataAgendamento());
        sessao2.setDescricao(sessao.getDescricao());
        sessao2.setTemaSessao(sessao.getTemaSessao());
        sessao2.setDuracao(sessao.getDuracao());
        sessao2.setTipoSessao(tipoSessao1);
        sessao2.getStatus().clear();

        Set<Status> statusSet = new HashSet<>();
        statusSet.add(status.orElseThrow(()-> new ResourceNotFoundException("Entity not found")));
        sessao2.setStatus(statusSet);

        pacienteDaSessao.getSessaoSet().remove(sessao2);

        pacienteDestinoSessao.addSessao(sessao2);
        pacienteRepository.save(pacienteDestinoSessao);

        return sessaoRepository.save(sessao2);

    }

    public Sessao atualizarStatusDaSessao(Long id, DescricaoUpdateDTO descricao, Long idStatus){
        Optional<Status> status = statusRepository.findById(idStatus);
        Optional<Sessao> sessao1 = sessaoRepository.findById(id);
        Sessao sessao2 = sessao1.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
        sessao2.setDescricao(descricao.getDescricao());
        sessao2.getStatus().clear();
        sessao2.addStatus(status.orElseThrow(()-> new ResourceNotFoundException("Entity not found")));
        return sessaoRepository.save(sessao2);
    }

    public void deletarSessao(Long id){
        try {
            sessaoRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found" + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrety violation");
        }
    }

}
