package com.example.psicologia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    private final static Long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAgendamento;
    private String temaSessao;
    private String duracao;
    private String descricao;
    @OneToOne
    private TipoSessao tipoSessao;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_sessao_status",
            joinColumns = @JoinColumn(name = "sessao_id"),
            inverseJoinColumns= @JoinColumn(name = "status_id"))
    private Set<Status> status = new HashSet<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "sessaoSet")
    private Set<Paciente> pacienteSet = new HashSet<>();

    public Sessao(){}

    public Sessao(Long id,
                  LocalDate dataAgendamento,
                  String temaSessao,
                  String duracao,
                  String descricao,
                  TipoSessao tipoSessao) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.temaSessao = temaSessao;
        this.duracao = duracao;
        this.descricao = descricao;
        this.tipoSessao = tipoSessao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Paciente> getPacienteSet() {
        return pacienteSet;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getTemaSessao() {
        return temaSessao;
    }

    public void setTemaSessao(String temaSessao) {
        this.temaSessao = temaSessao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public TipoSessao getTipoSessao() {
        return tipoSessao;
    }

    public void setTipoSessao(TipoSessao tipoSessao) {
        this.tipoSessao = tipoSessao;
    }

    public Set<Status> getStatus() {
        return status;
    }

    public void setStatus(Set<Status> status) {
        this.status = status;
    }

    public void addStatus(Status status){
        this.getStatus().add(status);
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
