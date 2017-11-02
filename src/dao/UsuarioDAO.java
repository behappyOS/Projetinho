package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario Usuario) {
		String sqlInsert = "INSERT INTO usuario(nome, email, login, senha, celular) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, Usuario.getNome());
			stm.setString(2, Usuario.getEmail());
			stm.setString(3, Usuario.getLogin());
			stm.setString(4, Usuario.getSenha());
			stm.setString(5, Usuario.getCelular());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					Usuario.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Usuario.getIdUsuario();
	}

	public void atualizar(Usuario Usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, login=?, senha=?, celular=? WHERE idUsuario=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, Usuario.getNome());
			stm.setString(2, Usuario.getEmail());
			stm.setString(3, Usuario.getLogin());
			stm.setString(4, Usuario.getSenha());
			stm.setString(5, Usuario.getCelular());
			stm.setInt(6, Usuario.getIdUsuario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int IdUsuario) {
		String sqlDelete = "DELETE FROM usuario WHERE idUsuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, IdUsuario);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int IdUsuario) {
		Usuario Usuario = new Usuario();
		String sqlSelect = "SELECT idUsuario, nome, email, login, senha, celular FROM usuario WHERE idUsuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, IdUsuario);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Usuario.setIdUsuario(rs.getInt("idUsuario"));
					Usuario.setNome(rs.getString("nome"));
					Usuario.setEmail(rs.getString("email"));
					Usuario.setLogin(rs.getString("login"));
					Usuario.setSenha(rs.getString("senha"));
					Usuario.setCelular(rs.getString("celular"));
				} else {
					Usuario.setIdUsuario(-1);
					Usuario.setLogin(null);
					Usuario.setEmail(null);
					Usuario.setLogin(null);
					Usuario.setSenha(null);
					Usuario.setCelular(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return Usuario;
	}
	
	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT login, senha FROM usuario "
				+ "WHERE login = ? and senha = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obterConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getLogin());
				stm.setString(2, usuario.getSenha());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

}
