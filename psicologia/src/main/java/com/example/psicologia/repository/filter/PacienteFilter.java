package com.example.psicologia.repository.filter;

public class PacienteFilter {

    private String nome;

    public PacienteFilter() {
    }

    public PacienteFilter(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
