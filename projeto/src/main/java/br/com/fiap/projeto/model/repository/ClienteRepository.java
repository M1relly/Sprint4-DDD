package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.projeto.model.entity.Cliente;

public class ClienteRepository extends Repository{

	/**
	 * Método para listagem de todos os clientes cadastrados 
	 * @Author Project P
	 * @return null or clientes
	 * */
	public static ArrayList<Cliente> findAll(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();		
		String sql = "select * from cliente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setCpf(rs.getInt("cpf_cl"));
					cliente.setNome(rs.getString("nome_cl"));
					cliente.setTelefone(rs.getInt("fone_cl"));

					clientes.add(cliente);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return clientes;
	}
	
	/**
	 * Método para inserir dados na tabela cliente
	 * @Author Project P
	 * @return cliente or null
	 * */
	public static Cliente save(Cliente cliente) {
		String sql = "insert into cliente"
				+ "(cpf_cl, nome_cl, fone_cl)"
				+ " values( ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cliente.getCpf());
			ps.setString(2, cliente.getNome());
			ps.setInt(3, cliente.getTelefone());
			if (ps.executeUpdate() > 0) {
				return cliente;
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
	 * Método para atualizar dados na tabela cliente
	 * @Author Project P
	 * @return cliente or null
	 * */
	public static Cliente update(Cliente cliente) {
		String sql = "update cliente"
				+ "set cpf_cl = ?, nome_cl = ?, fone_cl = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cliente.getCpf());
			ps.setString(2, cliente.getNome());
			ps.setInt(3, cliente.getTelefone());

			if (ps.executeUpdate() > 0) {
				return cliente;
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
	 * Método para deletar dados na tabela cliente
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int cpf) {
		String sql = "delete from cliente where cpf_cl = ?";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cpf);
			
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
