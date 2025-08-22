package com.analuiza.tarefasapi.repository;

import com.analuiza.tarefasapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
