package com.example.psicologia.dto;

import java.io.Serializable;

public class DescricaoUpdateDTO implements Serializable {

    private final static Long serialVersionUID = 1L;

    private String descricao;

    public DescricaoUpdateDTO(){}


    public DescricaoUpdateDTO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
