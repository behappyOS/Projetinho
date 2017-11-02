package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Avaliacao;
import model.Estabelecimento;
import model.Avaliacao;

public class AvaliacaoDAO {
	public int criar(Avaliacao Avaliacao) {
		String sqlInsert = "INSERT INTO Avaliacao(MediaAvaliacao) VALUES (?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setDouble(1, Avaliacao.getMediaAvaliacao());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_IdAvaliacao()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					Avaliacao.setIdAvaliacao(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Avaliacao.getIdAvaliacao();
	}

	public void atualizar(Avaliacao Avaliacao) {
		String sqlUpdate = "UPDATE Avaliacao SET MediaAvaliacao=? WHERE IdAvaliacao=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDouble(1, Avaliacao.getMediaAvaliacao());
			stm.setInt(4, Avaliacao.getIdAvaliacao());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int IdAvaliacao) {
		String sqlDelete = "DELETE FROM Avaliacao WHERE IdAvaliacao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, IdAvaliacao);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Avaliacao carregar(int IdAvaliacao) {
		Avaliacao Avaliacao = new Avaliacao();
		Avaliacao.setIdAvaliacao(IdAvaliacao);
		String sqlSelect = "SELECT MediaAvaliacao FROM Avaliacao WHERE Avaliacao.IdAvaliacao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, Avaliacao.getIdAvaliacao());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Avaliacao.setMediaAvaliacao(rs.getDouble("MediaAvaliacao"));
				} else {
					Avaliacao.setIdAvaliacao(-1);
					Avaliacao.setMediaAvaliacao(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return Avaliacao;
	}
	
	public ArrayList<Avaliacao> listarAvaliacoes() {
		Avaliacao Avaliacao;
		ArrayList<Avaliacao> lista = new ArrayList<>();
		String sqlSelect = "SELECT idAvaliacao, nomeFantasia, idUsuario\r\n" + 
				"FROM avaliacao \r\n" + 
				"INNER JOIN estabelecimento ON avaliacao.idEstabelecimento = avaliacao.idEstabelecimento" +
		"INNER JOIN usuario ON avaliacao.idUsuario = avaliacao.idUsuario";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Avaliacao = new Avaliacao();
					Avaliacao.setIdAvaliacao(rs.getInt(1));
					Avaliacao.estabelecimento.setNomeFantasia(rs.getString("nomeFantasia"));
					Avaliacao.usuario.setNome(rs.getString("nome"));
					lista.add(Avaliacao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Avaliacao> listarAvaliacoes(String chave) {
		Avaliacao Avaliacao;
		ArrayList<Avaliacao> lista = new ArrayList<>();
		String sqlSelect = "SELECT idAvaliacao, nomeFantasia, idUsuario\\r\\n" + 
				"FROM avaliacao \r\n" + 
				"INNER JOIN estabelecimento ON avaliacao.idEstabelecimento = avaliacao.idEstabelecimento where nomeFantasia like ?" +
		"INNER JOIN usuario ON avaliacao.idUsuario = avaliacao.idUsuario where nome like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Avaliacao = new Avaliacao();
					Avaliacao.setIdAvaliacao(rs.getInt(1));
					Avaliacao.estabelecimento.setNomeFantasia(rs.getString("nomeFantasia"));
					Avaliacao.usuario.setNome(rs.getString("nome"));
					lista.add(Avaliacao);
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
