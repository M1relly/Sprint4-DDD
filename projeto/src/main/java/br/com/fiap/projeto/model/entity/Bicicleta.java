package br.com.fiap.projeto.model.entity;


import jakarta.validation.constraints.NotNull;

public class Bicicleta {

	//@NotBlank
	private int numSerie;
	@NotNull
	private String modelo;
	@NotNull
	private float preco;
	
	// construtor vazio
	public Bicicleta() {

	}

	// construtor com passagem de parâmetro
	public Bicicleta(/*@NotBlank*/ int numSerie, @NotNull String modelo, @NotNull float preco) {
		super();
		this.numSerie = numSerie;
		this.modelo = modelo;
		this.preco = preco;
	}


	// getters e setters
	public int getNumSerie() {
		return numSerie;
	}


	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}

	
	
}