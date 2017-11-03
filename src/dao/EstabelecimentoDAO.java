package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Estabelecimento;

public class EstabelecimentoDAO {
	public int criar(Estabelecimento estabelecimento) {
		String sqlInsert = "INSERT INTO Estabelecimento(nomeFantasia, endereco, idCategoria) VALUES (?, ?, ?)";
		/* Categorias
		 * 1: Bar/Restaurantes
		 * 2: Cinema
		 * 3: Parque
		 */
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, estabelecimento.getNomeFantasia());
			stm.setString(2, estabelecimento.getEndereco());
			stm.setInt(3, estabelecimento.getCategoria());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					estabelecimento.setIdEst(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estabelecimento.getIdEst();
	}

	public void atualizar(Estabelecimento estabelecimento) {
		String sqlUpdate = "UPDATE Estabelecimento SET NomeFantasia=?, Endereco=?, idCategoria=? WHERE idEst=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, estabelecimento.getNomeFantasia());
			stm.setString(2, estabelecimento.getEndereco());
			stm.setInt(3, estabelecimento.getCategoria());
			stm.setInt(4, estabelecimento.getIdEst());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int IdEst) {
		String sqlDelete = "DELETE FROM Estabelecimento WHERE idEst = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, IdEst);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Estabelecimento carregar(int idEst) {
		Estabelecimento estabelecimento = new Estabelecimento();
		String sqlSelect = "SELECT idEst, nomeFantasia, endereco, idCategoria FROM projetointegrado.estabelecimento WHERE idEst = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idEst);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					estabelecimento.setIdEst(rs.getInt("idEst"));
					estabelecimento.setNomeFantasia(rs.getString("nomeFantasia"));
					estabelecimento.setEndereco(rs.getString("endereco"));
					estabelecimento.setCategoria(rs.getInt("idCategoria"));
				} else {
					estabelecimento.setIdEst(-1);
					estabelecimento.setNomeFantasia(null);
					estabelecimento.setEndereco(null);
					estabelecimento.setCategoria(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return estabelecimento;
	}
	public ArrayList<Estabelecimento> listarEstabelecimentos() {
		Estabelecimento estabelecimento;
		ArrayList<Estabelecimento> lista = new ArrayList<>();
		String sqlSelect = "SELECT idEst, nomeFantasia, endereco, categoria.nome \r\n" + 
				"				FROM estabelecimento \r\n" + 
				"				left JOIN categoria ON estabelecimento.idCategoria = categoria.idCategoria";
			
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					estabelecimento = new Estabelecimento();
					estabelecimento.setIdEst(rs.getInt("idEst"));
					estabelecimento.setNomeFantasia(rs.getString("nomeFantasia"));
					estabelecimento.setEndereco(rs.getString("endereco"));
					//estabelecimento.setCategoria(rs.getInt("idCategoria"));
					lista.add(estabelecimento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Estabelecimento> listarEstabelecimentos(String chave) {
		Estabelecimento estabelecimento;
		ArrayList<Estabelecimento> lista = new ArrayList<>();
		String sqlSelect = "SELECT idEst, nomeFantasia, endereco, categoria.nome\r\n" + 
				"FROM estabelecimento \r\n" + 
				"inner JOIN categoria ON estabelecimento.idCategoria = categoria.idCategoria where nome like ?";
			
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					estabelecimento = new Estabelecimento();
					estabelecimento.setIdEst(rs.getInt("idEst"));
					estabelecimento.setNomeFantasia(rs.getString("nomeFantasia"));
					estabelecimento.setEndereco(rs.getString("endereco"));
					//estabelecimento.setCategoria(rs.getInt("categoria.nome"));
					lista.add(estabelecimento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	

}
