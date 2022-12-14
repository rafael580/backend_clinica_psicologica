package com.example.psicologia.controller;

import com.example.psicologia.dto.DescricaoUpdateDTO;
import com.example.psicologia.entity.Sessao;
import com.example.psicologia.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sessao")
@CrossOrigin("*")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;


    @GetMapping
    public ResponseEntity<List<Sessao>> listarDeTodasSessoes(){
       return ResponseEntity.ok().body(sessaoService.todasSessoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> umaSessao(@PathVariable Long id){
        return ResponseEntity.ok().body(sessaoService.pegarUmaSessao(id));
    }

    @PostMapping("/criarsessao/{cpf}")
    public ResponseEntity<Sessao>  criarUmaSessao(@PathVariable String cpf,@Valid  @RequestBody Sessao sessao){
        return ResponseEntity.ok().body(sessaoService.criarSessao(cpf,sessao));
    }

    @PutMapping("/{id}/{pacienteAtual}/{pacienteDestino}")
    public ResponseEntity<Sessao>  atualizarUmaSessao(@PathVariable Long id,
                                                      @PathVariable String pacienteAtual,
                                                      @PathVariable String pacienteDestino,
                                                      @Valid @RequestBody Sessao sessao){
        return ResponseEntity.ok().body(sessaoService.atualizarSessao(id,sessao,pacienteAtual,pacienteDestino));
    }

    @PutMapping ("/{id}/{idStatus}")
    public ResponseEntity<Sessao>  atualizarStatusDeUmaSessao(
            @PathVariable Long id,
            @Valid @RequestBody DescricaoUpdateDTO descricao,
            @PathVariable Long idStatus){
        return ResponseEntity.ok().body(sessaoService.atualizarStatusDaSessao(id,descricao,idStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSessao(@PathVariable Long id){
        sessaoService.deletarSessao(id);
        return ResponseEntity.noContent().build();
    }


}
