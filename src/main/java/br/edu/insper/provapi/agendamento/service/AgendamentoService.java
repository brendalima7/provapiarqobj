package br.edu.insper.provapi.agendamento.service;

import br.edu.insper.provapi.cliente.model.Cliente;
import br.edu.insper.provapi.cliente.service.ClienteService;
import br.edu.insper.provapi.profissional.model.Profissional;
import br.edu.insper.provapi.profissional.service.ProfissionalService;
import br.edu.insper.provapi.agendamento.dto.AgendamentoCreateDTO;
import br.edu.insper.provapi.agendamento.exception.AgendamentoNaoEncontradoException;
import br.edu.insper.provapi.agendamento.model.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class AgendamentoService {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProfissionalService equipamentoService;

    HashMap<String, Agendamento> agendamentos = new HashMap<>(); // cria a lista que vai guardar os dados dos agendamento

    // aqui que dto entra
    public Agendamento criar(AgendamentoCreateDTO agendamentoDTO) {
        // parametros definidos por padrao no inicio como disponivel e deleted não entram aqui
        if ((agendamentoDTO.getDataAgendamento() == null ) || (agendamentoDTO.getHorario() == null ) || (agendamentoDTO.getClienteID() == null)) {
            throw new RuntimeException("Os campos do agendamento não podem ser null, vazio");
        }

        Cliente cliente = clienteService.buscar(agendamentoDTO.getClienteID());
        Profissional equipamentoDisponivel = equipamentoService.buscarDisponivel();
        Agendamento agendamento = new Agendamento(agendamentoDTO.getHorario(), agendamentoDTO.getDataAgendamento(), cliente );

        agendamento.setProfissional(equipamentoDisponivel);
        agendamento.setId(UUID.randomUUID().toString());

        agendamentos.put(agendamento.getId(), agendamento); // guardar no hashmap


        return agendamento;
    }

    public Agendamento buscar(String id) {
        Agendamento agendamento = agendamentos.get(id);
        if ((agendamento == null) || (agendamento.isDeleted())) {
            throw new AgendamentoNaoEncontradoException("Agendamento não encontrada");
        }
        return agendamento;
    }

    public ArrayList<Agendamento> listar() {

        ArrayList<Agendamento> response = new ArrayList<>();
        for (Agendamento agendamento : agendamentos.values()) {

            if (!agendamento.isDeleted()){
                response.add(agendamento);
            }
        }
        return response;
    }

    public void excluir(String id) {
        Agendamento agendamento = buscar(id);   // pega o objeto
        agendamento.setDeleted(true);       // altera o campo dele
    }

    public Agendamento editar(String id, Agendamento agendamento) {
        Agendamento agendamentobuscar = buscar(id);

        if (agendamento.getDataAgendamento() != null) {
            agendamentobuscar.setDataAgendamento(agendamento.getDataAgendamento());
        }
        if (agendamento.getHorario() != null) {
            agendamentobuscar.setHorario(agendamento.getHorario());
        }
        agendamentos.put(id, agendamentobuscar);
        return agendamentobuscar;
    }
}