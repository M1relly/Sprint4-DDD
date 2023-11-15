package br.com.fiap.projeto.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.projeto.model.entity.Bicicleta;

public class BicicletaRepository extends Repository{

	/**
	 * Método para listagem de todas as bicicletas cadastradas 
	 * @Author Project P
	 * @return null or  bicicletas
	 * */
	public static ArrayList<Bicicleta> findAll(){
		ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
		String sql = "select * from bicicleta";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Bicicleta bike = new Bicicleta();
					bike.setNumSerie(rs.getInt("num_de_serie_bc"));
					bike.setModelo(rs.getString("modelo_bc"));
					bike.setPreco(rs.getFloat("preco_bc"));
					bike.setCpfDono(rs.getLong("fk_cliente_cpf_cl"));
					bicicletas.add(bike);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
			e.printStackTrace();

		} finally {
			closeConnection();
		}
		
		return bicicletas;
	}
	
	/**
	 * Método para inserir dados na tabela bicicleta
	 * @Author Project P
	 * @return bike or null
	 * */
	public static Bicicleta save(Bicicleta bike) {
		String sql = "insert into bicicleta (num_de_serie_bc, modelo_bc, preco_bc, fk_cliente_cpf_cl) values (?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, bike.getNumSerie());
			ps.setString(2, bike.getModelo());
			ps.setFloat(3, bike.getPreco());
			ps.setLong(4, bike.getCpfDono());
			
			
			if (ps.executeUpdate() > 0) {
				return bike;
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
	 * Método para deletar dados na tabela bicicleta
	 * @Author Project P
	 * @return true or false
	 * */
	public static boolean delete(int numSerie) {
		String sql = "delete from bicicleta where num_de_serie_bc = ?";
		
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, numSerie);
			
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
	 * Método para atualizar dados na tabela bicicleta
	 * @Author Project P
	 * @return bike or null
	 * */
	public static Bicicleta update(Bicicleta bike) {
		String sql = "update bicicleta set modelo_bc = ?, preco_bc = ? where num_de_serie_bc = ? ";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, bike.getModelo());
			ps.setFloat(2, bike.getPreco());
			ps.setInt(3, bike.getNumSerie());
			
			if (ps.executeUpdate() > 0) {
				return bike;
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