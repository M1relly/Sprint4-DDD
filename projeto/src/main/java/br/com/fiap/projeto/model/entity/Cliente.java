package br.com.fiap.projeto.model.entity;

<<<<<<< HEAD
//import jakarta.validation.constraints.NotBlank;
=======
>>>>>>> c3fb5226af6be81b96ae9ab4091d0cb58d1fa7df
import jakarta.validation.constraints.NotNull;

public class Cliente {

<<<<<<< HEAD
	//@NotBlank
	private long cpf;
=======
	
	private int cpf;
>>>>>>> c3fb5226af6be81b96ae9ab4091d0cb58d1fa7df
	@NotNull
	private String nome;
	@NotNull
	private int telefone;
	
	
	public Cliente() {
	}


<<<<<<< HEAD
	public Cliente(/*@NotBlank*/ long cpf, @NotNull String nome, @NotNull long telefone) {
=======
	public Cliente(int cpf, @NotNull String nome, @NotNull int telefone) {
>>>>>>> c3fb5226af6be81b96ae9ab4091d0cb58d1fa7df
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