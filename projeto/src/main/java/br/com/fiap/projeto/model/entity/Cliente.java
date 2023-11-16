package br.com.fiap.projeto.model.entity;

//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Cliente {

	//@NotBlank
	private long cpf;
	@NotNull
	private String nome;
	@NotNull
	private long telefone;
	
	
	public Cliente() {
	}


	public Cliente(/*@NotBlank*/ long cpf, @NotNull String nome, @NotNull long telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}


	public long getCpf() {
		return cpf;
	}


	public void setCpf(long cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getTelefone() {
		return telefone;
	}


	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	
}