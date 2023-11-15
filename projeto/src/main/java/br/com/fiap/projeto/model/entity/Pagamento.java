package br.com.fiap.projeto.model.entity;

import java.sql.Date;

import javax.swing.JOptionPane;
//import jakarta.validation.constraints.FutureOrPresent;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Pagamento {

	//@FutureOrPresent
	private Date data;
	@NotNull
	private String forma;
	//@NotBlank
	private int id;
	


	public void escolherMetodoPagamento() {
		
        String[] opcoes = {"Crédito", "Débito", "Boleto", "Pix"};
        
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha o método de pagamento:",
                "Pagamento", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (opcaoSelecionada) {
            case 0:
                JOptionPane.showMessageDialog(null, "Método de pagamento selecionado: Crédito");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Método de pagamento selecionado: Débito");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Método de pagamento selecionado: Boleto");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Método de pagamento selecionado: Pix");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nenhum método de pagamento selecionado");
       }
        
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
	
	public String getForma() {
		return forma;
	}


	public void setForma(String forma) {
		this.forma = forma;
	}

	
}