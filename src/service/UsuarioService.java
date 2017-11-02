package service;

import model.Usuario;
import dao.UsuarioDAO;


public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario Usuario) {
		return dao.criar(Usuario);
	}
	
	public void atualizar(Usuario Usuario){
		dao.atualizar(Usuario);
	}
	
	public void excluir(int idUsuario){
		dao.excluir(idUsuario);
	}
	
	public Usuario carregar(int idUsuario){
		return dao.carregar(idUsuario);
	}
	
	public boolean validar(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}

}
