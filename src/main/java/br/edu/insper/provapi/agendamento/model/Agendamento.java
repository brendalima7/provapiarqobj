package br.edu.insper.provapi.agendamento.model;

import br.edu.insper.provapi.cliente.model.Cliente;
import br.edu.insper.provapi.profissional.model.Profissional;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
    private LocalTime horario;
    private LocalDate dataAgendamento;
    private Profissional profissional;
    private Cliente cliente;
    private String id;
    private boolean deleted;

    public Agendamento(LocalTime horario, LocalDate dataAgendamento, Cliente cliente ) {
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
        this.cliente = cliente;
        this.deleted = false;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
