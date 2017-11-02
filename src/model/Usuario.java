package model;

import java.io.Serializable;

import javax.swing.JOptionPane;
import service.UsuarioService;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String celular;
	
	public Usuario (int idUsuario, String nome, String login, String senha, String email, String celular) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.celular = celular;
	}
	
	public Usuario() {
		
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		//Adicionar os erros 
//		boolean tam = senha.matches(".{6,10}");
//		boolean letra = senha.matches(".*[A-z].*");
//		boolean numero = senha.matches(".*[0-9].*");
//		if (tam==false) {
//			this.senha = "Erro no tamanho";
//		}
//		else if (letra==false) {
//			this.senha = "Falta letra";
//		}
//		else if (numero==false) {
//			this.senha = "Falta digito";
//		}
//		else {
			this.senha = senha;
		//}	
	}
	
	public String validaSenha() {
		
		String senha = this.getSenha();
		boolean tam = senha.matches(".{6,10}");
		boolean letra = senha.matches(".*[A-z].*");
		boolean numero = senha.matches(".*[0-9].*");
		if (tam==false) {
			return "Erro no tamanho";
		}
		else if (letra==false) {
			return "Falta letra";
		}
		else if (numero==false) {
			return "Falta digito";
		}
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", celular=" + celular
				+ ", email=" + email + "]";
	}
	
	/*public static void main (String [] args) {
		Usuario usuario = new Usuario(1, "Jesus", "deusaolindo", "123456a", "jesus@criador.", "11000000000");
		String senhaOk = usuario.validaSenha();
		if (!senhaOk.equals("")) {
			JOptionPane.showMessageDialog(null, senhaOk);
		}
		UsuarioService us = new UsuarioService();

		usuario.setNome("Douglas");
		usuario.setLogin("dougrasloco5");
		usuario.setSenha("a12345");
		usuario.setEmail("do@teste.com");
		usuario.setCelular("11953751963");

		//us.excluir(1);
		//JOptionPane.showMessageDialog(null, "INCLUIDO COM SUCESSO");
		us.criar(usuario);
		//usuario = us.carregar(3);
		JOptionPane.showMessageDialog(null, usuario.getIdUsuario()+ "\n" + usuario.getNome()+ "\n" + usuario.getEmail()+ "\n" + usuario.getLogin()+ "\n" + usuario.getSenha()+ "\n" + usuario.getCelular());
	}		*/

}
