package br.edu.insper.provapi.profissional.model;

public class Profissional {

    private String nome;
    private String cpf;
    private String especialidade;
    private String id;
    private boolean disponivel;
    private boolean deleted;

    public Profissional(String nome, String cpf, String especialidade ) {
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.disponivel = true;
        this.deleted = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEspecialidade() { return especialidade; }

    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
