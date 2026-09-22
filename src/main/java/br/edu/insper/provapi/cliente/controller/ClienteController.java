package br.edu.insper.provapi.cliente.controller;

import br.edu.insper.provapi.cliente.model.Cliente;
import br.edu.insper.provapi.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    @GetMapping("/clientes/{id}")
    public Object getCliente(@PathVariable String id) {
        return clienteService.buscar(id);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable String id) {
        clienteService.excluir(id);
    }

    @GetMapping("/clientes")
    public ArrayList<Cliente> getclientes() {
        return clienteService.listar();
    }

    @PutMapping("/clientes/{id}")
    public Object putCliente (@PathVariable String id, @RequestBody Cliente cliente) {
        return clienteService.editar(id, cliente);
    }

}
