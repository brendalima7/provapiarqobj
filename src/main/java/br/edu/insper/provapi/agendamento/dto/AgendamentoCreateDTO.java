package br.edu.insper.provapi.agendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoCreateDTO {

    private LocalTime horario;
    private LocalDate dataAgendamento;
    private String clienteID; //identificador do cliente pelo id

    public AgendamentoCreateDTO(LocalTime horario, LocalDate dataAgendamento, String clienteID ) {
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
        // não recebe profissionais pq quem escolhe é a API
        this.clienteID = clienteID;
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

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }
}
