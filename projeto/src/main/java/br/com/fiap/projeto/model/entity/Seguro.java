package br.com.fiap.projeto.model.entity;

//import jakarta.validation.constraints.FutureOrPresent;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Seguro {

	//@FutureOrPresent
	private String duracao;
	//@NotBlank
	private int id;
	//@NotBlank
	private String status;
	@NotNull
	private long cpfDono;
	
	
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getCpfDono() {
		return cpfDono;
	}
	
	public void setCpfDono(long cpfDono) {
		this.cpfDono = cpfDono;
	}
	

}