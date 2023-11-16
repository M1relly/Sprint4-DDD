package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.projeto.model.entity.Seguro;

public class SeguroRepository extends Repository{

	
	/**
	 * Método para retornar dados do seguro
	 * @Author Project P
	 * @return null or seguros
	 * */
	public static ArrayList<Seguro> findAll(){
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		String sql = "select * from seguro";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Seguro seguro = new Seguro();
					seguro.setId(rs.getInt("id_sg"));
					seguro.setStatus(rs.getString("status_sg"));
					seguro.setDuracao(rs.getString("duracao_sg"));
					seguro.setCpfDono(rs.getLong("fk_cliente_cpf_cl"));
					seguros.add(seguro);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		
		return seguros;
	}
	
	
	/**
	 * Método para inserir dados na tabela seguro
	 * @Author Project P
	 * @return seguro or null
	 * */
	public static Seguro save(Seguro seguro) {
		String sql = "insert into seguro "
				+ "(id_sg, status_sg, duracao_sg, fk_cliente_cpf_cl) "
				+ " values (?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, seguro.getId());
			ps.setString(2, seguro.getStatus());
			ps.setString(3, seguro.getDuracao());
			ps.setLong(4, seguro.getCpfDono());
			
			
			if (ps.executeUpdate() > 0) {
				return seguro;
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
	 * Método para deletar dados na tabela seguro
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int id) {
		String sql = "delete from seguro where id_sg = ?";
		
		
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
	 * Método para atualizar dados na tabela seguro
	 * @Author Project P
	 * @return seguro or null
	 * */
	public static Seguro update(Seguro seguro) {
		String sql = "update seguro"
				+ " set status_sg = ?, duracao_sg = ?, fk_cliente_cpf_cl = ? where id_sg = ? ";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, seguro.getDuracao());
			ps.setString(2, seguro.getStatus());
			ps.setInt(3, seguro.getId());
			ps.setLong(4, seguro.getCpfDono());
			
			if (ps.executeUpdate() > 0) {
				return seguro;
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