package br.edu.insper.provapi.agendamento.controller;

import br.edu.insper.provapi.agendamento.dto.AgendamentoCreateDTO;
import br.edu.insper.provapi.agendamento.model.Agendamento;
import br.edu.insper.provapi.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento criarAgendamento(@RequestBody AgendamentoCreateDTO agendamentoDTO) {
        return agendamentoService.criar(agendamentoDTO);
    }

    @GetMapping("/agendamentos/{id}")
    public Agendamento getAgendamento(@PathVariable String id) {
        return agendamentoService.buscar(id);
    }

    @DeleteMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAgendamento(@PathVariable String id) {
        agendamentoService.excluir(id);
    }

    @GetMapping("/agendamentos")
    public ArrayList<Agendamento> getTodasAgendamento() {
        return agendamentoService.listar();
    }

    @PutMapping("/agendamentos/{id}")
    public Agendamento putAgendamentoo (@PathVariable String id, @RequestBody Agendamento agendamento) {
        return agendamentoService.editar(id, agendamento);
    }


}
