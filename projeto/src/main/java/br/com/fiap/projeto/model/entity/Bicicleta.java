package br.com.fiap.projeto.model.entity;


import jakarta.validation.constraints.NotNull;

public class Bicicleta {

	//@NotBlank
	private int numSerie;
	@NotNull
	private String modelo;
	@NotNull
	private float preco;
	@NotNull
	private long cpfDono;
	
	// construtor vazio
	public Bicicleta() {

	}

	// construtor com passagem de parâmetro
	public Bicicleta(/*@NotBlank*/ int numSerie, @NotNull String modelo, @NotNull float preco, @NotNull long cpfDono) {
		super();
		this.numSerie = numSerie;
		this.modelo = modelo;
		this.preco = preco;
		this.cpfDono = cpfDono;
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

	public long getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(long cpfDono) {
		this.cpfDono = cpfDono;
	}

	
	
}