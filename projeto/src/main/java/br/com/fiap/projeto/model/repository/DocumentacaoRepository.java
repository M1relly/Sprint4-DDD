package br.com.fiap.projeto.model.repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.projeto.model.entity.Documentacao;

public class DocumentacaoRepository extends Repository{

	
	/**
	 * Método para listagem de todos os documentos cadastrados 
	 * @Author Project P
	 * @return null or documentos
	 * */
	public static ArrayList<Documentacao> findAll(){
		ArrayList<Documentacao> documentos = new ArrayList<Documentacao>();		
		String sql = "select * from documentacao";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Documentacao doc = new Documentacao();
					doc.setId(rs.getInt("id_dc"));
					doc.setDescricao(rs.getString("descricao_dc"));
					doc.setDataCompra(rs.getDate("data_compra_dc"));

					documentos.add(doc);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " +e.getMessage());
		} finally {
			closeConnection();
		}
		return documentos;
	}
	
	
	/**
	 * Método para inserir dados na tabela documentacao
	 * @Author Project P
	 * @return doc or null
	 * */
	public static Documentacao save(Documentacao doc) {
		String sql = "insert into documentacao"
				+ "(id_dc, descricao_dc, data_compra_dc)"
				+ " values(null, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, doc.getDescricao());
			ps.setDate(2, doc.getDataCompra());

			if (ps.executeUpdate() > 0) {
				return doc;
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
	 * Método para atualizar dados na tabela documentacao
	 * @Author Project P
	 * @return doc or null
	 * */
	public static Documentacao update(Documentacao doc) {
		String sql = "update documentacao"
				+ "set descricao_dc = ?, data_compra_dc = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, doc.getDescricao());
			ps.setDate(2, doc.getDataCompra());
			if (ps.executeUpdate() > 0) {
				return doc;
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
	 * Método para deletar dados na tabela documentacao
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int id) {
		String sql = "delete from documentacao where id_dc = ?";
		
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
