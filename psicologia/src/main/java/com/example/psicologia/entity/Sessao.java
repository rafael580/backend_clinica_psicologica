package com.example.psicologia.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "nome nao pode ser nulo")
    private String nome;
    private LocalDate dataAgendamento;
    private String temaSessao;
    private String duracao;
    @OneToOne
    private TipoSessao tipoSessao;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_sessao_status",
            joinColumns = @JoinColumn(name = "sessao_id"),
            inverseJoinColumns= @JoinColumn(name = "status_id"))
    private Set<Status> status = new HashSet<>();

    public Sessao(){}

    public Sessao(Long id,
                  String nome,
                  LocalDate dataAgendamento,
                  String temaSessao,
                  String duracao,
                  TipoSessao tipoSessao
               ) {
        this.id = id;
        this.nome = nome;
        this.dataAgendamento = dataAgendamento;
        this.temaSessao = temaSessao;
        this.duracao = duracao;
        this.tipoSessao = tipoSessao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
