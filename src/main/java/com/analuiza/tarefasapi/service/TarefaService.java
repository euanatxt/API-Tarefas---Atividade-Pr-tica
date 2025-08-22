package com.analuiza.tarefasapi.service;

import com.analuiza.tarefasapi.model.Tarefa;
import com.analuiza.tarefasapi.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listar() { return repository.findAll(); }
    public Tarefa buscar(Long id) { return repository.findById(id).orElse(null); }
    public Tarefa salvar(Tarefa tarefa) { return repository.save(tarefa); }
    public Tarefa atualizar(Long id, Tarefa dados) {
        return repository.findById(id).map(t -> {
            t.setNome(dados.getNome());
            t.setDataEntrega(dados.getDataEntrega());
            t.setResponsavel(dados.getResponsavel());
            return repository.save(t);
        }).orElse(null);
    }
    public boolean remover(Long id) {
        if (repository.existsById(id)) { repository.deleteById(id); return true; }
        return false;
    }
}
