package br.com.fiap.projeto.model.entity;

import java.sql.Date;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Contrato {

	@NotNull
	private String acordo;
	@FutureOrPresent
	private Date data;
	@NotBlank
	private int id;
	
	
	public String getAcordo() {
		return acordo;
	}
	public void setAcordo(String acordo) {
		this.acordo = acordo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	
	
}