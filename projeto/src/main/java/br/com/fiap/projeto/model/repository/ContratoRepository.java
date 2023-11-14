package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.projeto.model.entity.Contrato;

public class ContratoRepository extends Repository{

	
	/**
	 * Método para retorno dos dados do contrato
	 * @Author Project P
	 * @return null or contratos
	 * */
	public static ArrayList<Contrato> findAll(){
		ArrayList<Contrato> contratos = new ArrayList<Contrato>();
		String sql = "select * from contrato";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Contrato cont = new Contrato();
					cont.setId(rs.getInt("id_ct"));
					cont.setAcordo(rs.getString("acordo_ct"));
					cont.setData(rs.getDate("data_ct"));
					contratos.add(cont);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		
		return contratos;
	}
	
	/**
	 * Método para inserir dados na tabela  contrato
	 * @Author Project P
	 * @return cont or null
	 * */
	public static Contrato save(Contrato cont) {
		String sql = "insert into contrato (id_ct, acordo_ct, data_ct) values (?, ?, ?)";
		
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cont.getId());
			ps.setString(2, cont.getAcordo());
			ps.setDate(3, cont.getData());
			
			
			if (ps.executeUpdate() > 0) {
				return cont;
			} else {
				return null;
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar informações" + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
	/**
	 * Método para deletar dados na tabela contrato
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int id) {
		String sql = "delete from contrato where id_ct = ?";
		
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao apagar registro: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
	
	
	/**
	 * Método para atualizar dados na tabela contrato
	 * @Author Project P
	 * @return cont or null
	 * */
	public static Contrato update(Contrato cont) {
		String sql = "update contrato set acordo_ct = ?, data_ct = ? where id_ct = ? ";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cont.getAcordo());
			ps.setDate(2, cont.getData());
			ps.setInt(3, cont.getId());
			
			if (ps.executeUpdate() > 0) {
				return cont;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar informações: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
}