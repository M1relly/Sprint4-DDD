package br.com.fiap.projeto.model.entity;

//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Componentes {

	//@NotBlank
	private int id;
	@NotNull
	private String marca;
	@NotNull
	private String nome;
	@NotNull
	private long numBike;
	
	
	public Componentes() {
	}


	public Componentes(/*@NotBlank*/ int id, @NotNull String marca, @NotNull String nome, @NotNull long numBike) {
		super();
		this.id = id;
		this.marca = marca;
		this.nome = nome;
		this.setNumBike(numBike);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getNumBike() {
		return numBike;
	}


	public void setNumBike(long numBike) {
		this.numBike = numBike;
	}
	
	
	

	
	
}