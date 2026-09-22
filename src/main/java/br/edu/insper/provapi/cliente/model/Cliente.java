package br.edu.insper.provapi.cliente.model;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String id;
    private LocalDate dataCadastro;
    private boolean deleted;

    public Cliente(String nome, String email, String cpf, String telefone, LocalDate dataCadastro ) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.deleted = false;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getDataCadastro() { return dataCadastro;}

    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
}
