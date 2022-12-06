package com.example.psicologia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/sessao")
public class SessaoController {


    @GetMapping
    public LocalDate data(){
        LocalDate localDate  =   LocalDate.now();
        return localDate;
    }
}
