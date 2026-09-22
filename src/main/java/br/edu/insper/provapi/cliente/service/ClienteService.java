package br.edu.insper.provapi.cliente.service;

import br.edu.insper.provapi.cliente.exception.ClienteNaoEncontradoException;
import br.edu.insper.provapi.cliente.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ClienteService {

    HashMap<String, Cliente> clientes = new HashMap<>(); // cria a lista que vai guardar os dados dos clientes


    public Cliente criar(Cliente cliente) {

        if ((cliente.getNome() == null || cliente.getNome().isEmpty()) || (cliente.getCpf() == null || cliente.getCpf().isEmpty()) || (cliente.getEmail() == null || cliente.getEmail().isEmpty()) || (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) || (cliente.getDataCadastro() == null)) {
            throw new RuntimeException("Os campos do cliente não podem ser null ou vazio");
        }

        cliente.setId(UUID.randomUUID().toString());
        clientes.put(cliente.getId(), cliente);
        return cliente;
    }

    public Cliente buscar(String id) {
        Cliente cliente = clientes.get(id);
        if ((cliente == null) || (cliente.isDeleted())) {
            throw new ClienteNaoEncontradoException("Cliente não encontrada");
        }
        return cliente;
    }

    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> response = new ArrayList<>();
        for (Cliente cliente : clientes.values()) {

            if (!cliente.isDeleted()){
                response.add(cliente);
            }
        }
        return response;
        /*
        editoras
                .values()
                .stream()
                .filter(e -> e.getNome().startsWith(nome))
                .toList();
         */
    }

    public void excluir(String id) {
        Cliente cliente = buscar(id);   // pega o objeto
        cliente.setDeleted(true);       // altera o campo dele
    }

    public Cliente editar(String id, Cliente cliente) {
        Cliente clientebuscar = buscar(id);
        clientebuscar.setNome(cliente.getNome());
        clientebuscar.setCpf(cliente.getCpf());
        clientebuscar.setEmail(cliente.getEmail());
        clientebuscar.setTelefone(cliente.getTelefone());

        return clientebuscar;
    }
}
