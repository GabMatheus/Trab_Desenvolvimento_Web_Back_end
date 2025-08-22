package com.example.demomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demomvc.entity.Tarefa;
import com.example.demomvc.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaRestController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public List<Tarefa> listar() {
        return service.buscaTodos();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Tarefa criar(@Valid @RequestBody Tarefa tarefa) {
        service.salvar(tarefa);
        return tarefa;
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        service.editar(tarefa);
        return tarefa;
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "Tarefa excluída com sucesso!";
    }
}
