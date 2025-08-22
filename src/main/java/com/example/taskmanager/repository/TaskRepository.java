/*
 * Projeto: Desenvolvimento da API 
 * Autor: Ana Luiza
 * RU: 4706190
 * Data: 12/12/2025
 */

package com.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
