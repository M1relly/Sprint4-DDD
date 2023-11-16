package br.com.fiap.projeto.model.entity;

import java.sql.Date;

//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Documentacao {
	
	@PastOrPresent
	private Date dataCompra;
	@NotNull
	private String descricao;
	//@NotBlank
	private int id;
	@NotNull
	private long cpfDono;
	
	public Documentacao() {
	}

	public Documentacao(@PastOrPresent Date data_compra, @NotNull String descricao, /*@NotBlank*/ int id, long cpfDono) {
		super();
		this.dataCompra = data_compra;
		this.descricao = descricao;
		this.id = id;
		this.cpfDono = cpfDono;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date data_compra) {
		this.dataCompra = data_compra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(long cpfDono) {
		this.cpfDono = cpfDono;
	}
	
	
	

	
}