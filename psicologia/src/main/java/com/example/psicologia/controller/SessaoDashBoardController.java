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
    public void sessoesmes(){

    }
    @GetMapping("/sessoesmescanceladas")
    public void sessoesmescanceladas(){

    }
    @GetMapping("/sessoesindividuaistotal")
    public void sessoesindividuaistotal(){

    }
    @GetMapping("/sessoesgrupototal")
    public void sessoesgrupototal(){

    }
    @GetMapping("/sessoesduplatotal")
    public void sessoesduplatotal(){

    }


}
