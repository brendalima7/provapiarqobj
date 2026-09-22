package br.edu.insper.provapi.profissional.controller;

import br.edu.insper.provapi.profissional.model.Profissional;
import br.edu.insper.provapi.profissional.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProfissionalController {
    
    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping("/profissionais")
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional criarProfissional(@RequestBody Profissional profissional) {
        return profissionalService.criar(profissional);
    }

    @GetMapping("/profissionais/{id}")
    public Object getProfissional(@PathVariable String id) {
        return profissionalService.buscar(id);
    }

    @DeleteMapping("/profissionais/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfissional(@PathVariable String id) {
        profissionalService.excluir(id);
    }

    @GetMapping("/profissionais")
    public ArrayList<Profissional> getProfissionals() {
        return profissionalService.listar();
    }

    @PutMapping("/profissionais/{id}")
    public Object putProfissional (@PathVariable String id, @RequestBody Profissional profissional) {
        return profissionalService.editar(id, profissional);
    }


}
