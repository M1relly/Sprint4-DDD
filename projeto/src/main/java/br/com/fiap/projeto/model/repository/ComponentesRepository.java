package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.fiap.projeto.model.entity.Componentes;

public class ComponentesRepository extends Repository{

	/**
	 * Método para listagem de todos os componentes cadastrados 
	 * @Author Project P
	 * @return null or componentes
	 * */
	public static ArrayList<Componentes> findAll(){
		ArrayList<Componentes> componentes = new ArrayList<Componentes>();		
		String sql = "select * from componentes";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Componentes comp = new Componentes();
					comp.setId(rs.getInt("id_cp"));
					comp.setNome(rs.getString("nome_cp"));
					comp.setMarca(rs.getString("marca_cp "));
					componentes.add(comp);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return componentes;
	}
	
	
	/**
	 * Método para inserir dados na tabela componentes
	 * @Author Project P
	 * @return comp or null
	 * */
	public static Componentes save(Componentes comp) {
		String sql = "insert into componentes"
				+ "(id_cp, nome_cp, marca_cp)"
				+ " values(null, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, comp.getNome());
			ps.setString(2, comp.getMarca());

			if (ps.executeUpdate() > 0) {
				return comp;
			} else {				
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
	/**
	 * Método para atualizar dados na tabela componentes
	 * @Author Project P
	 * @return comp or null
	 * */
	public static Componentes update(Componentes comp) {
		String sql = "update componentes"
				+ "set nome_cp = ?, marca_cp = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, comp.getNome());
			ps.setString(2, comp.getMarca());

			if (ps.executeUpdate() > 0) {
				return comp;
			} else {				
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
	/**
	 * Método para deletar dados na tabela componentes
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int id) {
		String sql = "delete from componentes where id_cp = ?";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		} finally {
			closeConnection();
		} return false;
	} 
	
	
	
}
