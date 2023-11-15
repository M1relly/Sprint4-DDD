package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.projeto.model.entity.Pagamento;

public class PagamentoRepository extends Repository{

	
	/**
	 * Método para retorno de informações do pagamento
	 * @Author Project P
	 * @return null or pagamentos
	 * */
	public static ArrayList<Pagamento> findAll(){
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();		
		String sql = "select * from pagamento";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Pagamento pag = new Pagamento();
					pag.setId(rs.getInt("id_pg"));
					pag.setForma(rs.getString("forma_pg"));
					pag.setData(rs.getDate("data_pg"));

					pagamentos.add(pag);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return pagamentos;
	}
	
	
	/**
	 * Método para inserir dados na tabela pagamento
	 * @Author Project P
	 * @return pag or null
	 * */
	public static Pagamento save(Pagamento pag) {
		String sql = "insert into pagamento"
				+ "(id_pg, forma_pg, data_pg)"
				+ " values(?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, pag.getId());
			ps.setString(2, pag.getForma());
			ps.setDate(3, pag.getData());
			
			if (ps.executeUpdate() > 0) {
				return pag;
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
	 * Método para atualizar dados na tabela pagamento
	 * @Author Project P
	 * @return pag or null
	 * */
	public static Pagamento update(Pagamento pag) {
		String sql = "update pagamento"
				+ " set data_pg = ?, forma_pg = ? where id_pg = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDate(1, pag.getData());
			ps.setString(2, pag.getForma());
			ps.setInt(3, pag.getId());
	

			if (ps.executeUpdate() > 0) {
				return pag;
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
	 * Método para deletar dados na tabela pagamento
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int id) {
		String sql = "delete from pagamento where id_pg = ?";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
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
