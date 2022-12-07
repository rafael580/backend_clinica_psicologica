package com.example.psicologia.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private final static Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "nome nao pode ser nulo")
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String email;
    private String cidade;
    private String municipio;
    private String telefone;
    @OneToOne
    private Genero genero;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_paciente_sessao",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns= @JoinColumn(name = "sessao_id"))
    private Set<Sessao> sessaoSet = new HashSet<>();
    public Paciente(){}

    public Paciente(Long id,
                    String nome,
                    String dataNascimento,
                    String cpf,
                    Genero genero,
                    String endereco,
                    String email,
                    String cidade,
                    String municipio,
                    String telefone) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.genero = genero;
        this.endereco = endereco;
        this.email = email;
        this.cidade = cidade;
        this.municipio = municipio;
        this.telefone = telefone;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Sessao> getSessaoSet() {
        return sessaoSet;
    }

    public void setSessaoSet(Set<Sessao> sessaoSet) {
        this.sessaoSet = sessaoSet;
    }

    public void addSessao(Sessao sessao){
        this.getSessaoSet().add(sessao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
