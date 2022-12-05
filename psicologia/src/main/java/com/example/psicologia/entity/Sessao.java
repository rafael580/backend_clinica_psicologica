package com.example.psicologia.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    private final static Long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "nome nao pode ser nulo")
    private String nome;
    private String dataAgendamento;
    private String temaSessao;
    private String duracao;
    @OneToOne
    private TipoSessao tipoSessao;
    @OneToOne
    private Status status;

    public Sessao(){}

    public Sessao(Long id, String nome,
                  String dataAgendamento,
                  String temaSessao,
                  String duracao,
                  TipoSessao tipoSessao, Status status) {
        this.id = id;
        this.nome = nome;
        this.dataAgendamento = dataAgendamento;
        this.temaSessao = temaSessao;
        this.duracao = duracao;
        this.tipoSessao = tipoSessao;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessao sessao = (Sessao) o;
        return Objects.equals(id, sessao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
