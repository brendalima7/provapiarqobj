package br.edu.insper.provapi.profissional.service;

import br.edu.insper.provapi.profissional.exception.ProfissionalNaoEncontradoException;
import br.edu.insper.provapi.profissional.model.Profissional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ProfissionalService {

    HashMap<String, Profissional> profissionais = new HashMap<>(); // cria a lista que vai guardar os dados dos profissionais


    public Profissional criar(Profissional profissional) {
        // parametros definidos por padrao no inicio como disponivel e deleted não entram aqui
        if ((profissional.getNome() == null || profissional.getNome().isEmpty()) || (profissional.getCpf() == null || profissional.getCpf().isEmpty()) || (profissional.getEspecialidade() == null || profissional.getEspecialidade().isEmpty())) {
            throw new RuntimeException("Os campos de profissional não podem ser null ou vazio");
        }

        profissional.setId(UUID.randomUUID().toString());
        profissionais.put(profissional.getId(), profissional);
        return profissional;
    }

    public Profissional buscar(String id) {
        Profissional profissional = profissionais.get(id);
        if ((profissional == null) || (profissional.isDeleted())) {
            throw new ProfissionalNaoEncontradoException("Profissional não encontrada");
        }
        return profissional;
    }

    public ArrayList<Profissional> listar() {

        ArrayList<Profissional> response = new ArrayList<>();
        for (Profissional profissional : profissionais.values()) {

            if (!profissional.isDeleted()){
                response.add(profissional);
            }
        }
        return response;
    }

    public void excluir(String id) {
        Profissional profissional = buscar(id);   // pega o objeto
        profissional.setDeleted(true);       // altera o campo dele
    }

    public Profissional editar(String id, Profissional profissional) {
        Profissional profissionalbuscar = buscar(id);

        profissionalbuscar.setCpf(profissional.getCpf());
        profissionalbuscar.setEspecialidade(profissional.getEspecialidade());

        if (profissional.getNome() != null && !profissional.getNome().isEmpty()) {
            profissionalbuscar.setNome(profissional.getNome());
        }

        if (profissional.getCpf() != null && !profissional.getCpf().isEmpty()) {
            profissionalbuscar.setCpf(profissional.getCpf());
        }

        if (profissional.getEspecialidade() != null && !profissional.getEspecialidade().isEmpty()) {
            profissionalbuscar.setEspecialidade(profissional.getEspecialidade());
        }

        profissionais.put(id, profissionalbuscar);

        return profissionalbuscar;
    }

    public Profissional buscarDisponivel() {

        for (Profissional profissional : profissionais.values()) {
            if (!profissional.isDeleted() && profissional.isDisponivel()){
                return profissional;
            }
        }
        throw new ProfissionalNaoEncontradoException("Nenhum profissional disponível");
    }
}
