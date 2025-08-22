/*
 * Projeto: API RESTful de Gerenciamento de Tarefas
 * Autor: Ana Luiza
 * RU: 4706190
 * Data: 12/12/2025
 */

package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @DeleteMapping("/<built-in function id>")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
