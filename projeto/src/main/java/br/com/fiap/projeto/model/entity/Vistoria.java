package br.com.fiap.projeto.model.entity;

import java.sql.Date;
import javax.swing.JOptionPane;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

public class Vistoria {

	@FutureOrPresent
	private Date data;
	@NotBlank
	private int id;
	@NotBlank
	private String status;
	
	
	


	// construtor vazio
	public Vistoria() {
	}


	// construtor com parâmetro
	public Vistoria(@FutureOrPresent Date data, @NotBlank int id, @NotBlank String status) {
		this.data = data;
		this.id = id;
		this.status = status;
	}


	// getters e setters
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	/**
	 * Método para aprovação da Bike
	 * @author ProjectP
	 * @return status da verificação: True (aprovada) e False (negada)
	 */
	public Boolean aprovaBike() {
        String resposta = JOptionPane.showInputDialog("O cliente já enviou as fotos da bicicleta e chassi? (sim/não)");

        if (resposta.equalsIgnoreCase("sim")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mande as fotos imediatamente para a vistoria.");
            return false;
        }
    }
	
}