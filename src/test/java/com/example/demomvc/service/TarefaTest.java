package com.example.demomvc.service;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demomvc.entity.Tarefa;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class TarefaTest {

    @Autowired    
    private TarefaServiceImpl ts;

    @Test
    @Order(1)
    public void insere() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("revisao");
        tarefa.setResponsavel("GABRIEL");
        tarefa.setDataEntrega(LocalDate.of(2025, 8, 21));
        
        ts.salvar(tarefa);
        System.out.println("✅ Tarefa inserida com sucesso!");
    }

    @Test
    @Order(2)
    public void pesquisaPeloId() {
        Tarefa tarefa = ts.buscarPorId(2L);
        System.out.println("🔎 Pesquisa pelo ID: " + tarefa);
    }

    @Test
    @Order(3)
    public void atualiza() {
        Tarefa tarefa = ts.buscarPorId(2L);
        tarefa.setNome("Review");
        ts.editar(tarefa);
        System.out.println("✏️ Tarefa atualizada!");
    }

    @Test
    @Order(4)
    public void remove() {
        Tarefa tarefa = ts.buscarPorId(2L);
        ts.excluir(tarefa.getId());
        System.out.println("🗑️ Tarefa removida!");
    }
}
