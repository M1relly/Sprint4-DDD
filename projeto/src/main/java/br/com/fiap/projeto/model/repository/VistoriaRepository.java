package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.projeto.model.entity.Vistoria;

public class VistoriaRepository extends Repository{

	
	/**
	 * Método para retornar dados da vistoria
	 * @Author Project P
	 * @return null or vistorias
	 * */
	public static ArrayList<Vistoria> findAll(){
		ArrayList<Vistoria> vistorias = new ArrayList<Vistoria>();
		String sql = "select * from vistoria";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Vistoria vist = new Vistoria();
					vist.setId(rs.getInt("id_vs"));
					vist.setStatus(rs.getString("status_vs"));
					vist.setData(rs.getDate("data_vs"));
					vistorias.add(vist);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		
		return vistorias;
	}
	
	
	
	/**
	 * Método para inserir dados na tabela vistoria
	 * @Author Project P
	 * @return vist or null
	 * */
	public static Vistoria save(Vistoria vist) {
		String sql = "insert into vistoria (id_vs, status_vs, data_vs) values (?, ?, ?)";
		
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, vist.getId());
			ps.setString(2, vist.getStatus());
			ps.setDate(3, vist.getData());
			
			
			if (ps.executeUpdate() > 0) {
				return vist;
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
	 * Método para deletar dados na tabela vistoria
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int id) {
		String sql = "delete from vistoria where id_vs = ?";
		
		
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
	 * Método para atualizar dados na tabela vistoria
	 * @Author Project P
	 * @return vist or null
	 * */
	public static Vistoria update(Vistoria vist) {
		String sql = "update vistoria set status_vs = ?, data_vs = ? where id_vs = ? ";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vist.getStatus());
			ps.setDate(2, vist.getData());
			ps.setInt(3, vist.getId());
			
			if (ps.executeUpdate() > 0) {
				return vist;
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