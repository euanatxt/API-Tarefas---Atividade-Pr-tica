package com.analuiza.tarefasapi.controller;

import com.analuiza.tarefasapi.model.Tarefa;
import com.analuiza.tarefasapi.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService service;
    public TarefaController(TarefaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa) {
        Tarefa criada = service.salvar(tarefa);
        return ResponseEntity.created(URI.create("/tarefas/" + criada.getId())).body(criada);
    }
    @GetMapping public List<Tarefa> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        Tarefa t = service.buscar(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        Tarefa t = service.atualizar(id, tarefa);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return service.remover(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
