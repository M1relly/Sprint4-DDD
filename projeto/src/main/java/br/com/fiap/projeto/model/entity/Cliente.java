package br.com.fiap.projeto.model.entity;

import jakarta.validation.constraints.NotNull;

public class Cliente {

	
	private int cpf;
	@NotNull
	private String nome;
	@NotNull
	private int telefone;
	
	
	public Cliente() {
	}


	public Cliente(int cpf, @NotNull String nome, @NotNull int telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}