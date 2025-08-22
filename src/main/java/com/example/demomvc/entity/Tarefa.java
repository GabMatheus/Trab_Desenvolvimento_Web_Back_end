package com.example.demomvc.entity;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="TAREFA")
public class Tarefa extends AbstractEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O nome da tarefa é obrigatória")
	@Size(min = 2 , max = 60, message = "O nome deve conter no minimo {min} e maximo {max} caractere")
	@Column(name="nome" , nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "O campo de data é obrigatorio")
	@Column(name="data_entrega" , nullable = false, columnDefinition = "DATE")	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate dataEntrega;
	
	@NotBlank(message = "O nome do responsavel é obrigatório")
	@Column(name="responsavel" , nullable = false, length = 60)
	private String responsavel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
