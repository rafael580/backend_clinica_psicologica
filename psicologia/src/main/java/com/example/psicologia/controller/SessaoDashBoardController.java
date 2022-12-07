package com.example.psicologia.controller;

import com.example.psicologia.service.SessaoDashborasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Dashborad")
public class SessaoDashBoardController {

    @Autowired
    private SessaoDashborasService sessaoDashborasService;

    @GetMapping("/totalDeSessoes")
    public ResponseEntity<Integer> todasSessoes(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalDeSessoes());
    }
    @GetMapping("/sessoesdia")
    public ResponseEntity<Integer> sessoesdia(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalDeSessoesDia());
    }
    @GetMapping("/sessoesmes")
    public ResponseEntity<Integer> sessoesmes(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalSessoesMes());
    }
    @GetMapping("/sessoesmescanceladas")
    public ResponseEntity<Integer> sessoesmescanceladas(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalSessoesMesCanceladas());
    }
    @GetMapping("/sessoesindividuaistotal")
    public ResponseEntity<Integer> sessoesindividuaistotal(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalsessoesindividual());
    }
    @GetMapping("/sessoesgrupototal")
    public ResponseEntity<Integer>sessoesgrupototal(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalsessoesgrupo());
    }
    @GetMapping("/sessoesduplatotal")
    public ResponseEntity<Integer> sessoesduplatotal(){
        return ResponseEntity.ok().body(sessaoDashborasService.totalsessoesdupla());
    }
}
