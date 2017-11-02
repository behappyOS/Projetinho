package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class AlterarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdUsuario = request.getParameter("idUsuario");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pCelular = request.getParameter("celular");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");
		int idUsuario = -1;
		try {
			idUsuario = Integer.parseInt(pIdUsuario);
		} catch (NumberFormatException e) {

		}

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setCelular(pCelular);
		usuario.setLogin(pLogin);
		usuario.setSenha(pSenha);
		
		UsuarioService us = new UsuarioService();
		RequestDispatcher view = null;


		us.atualizar(usuario);

		request.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("VisualizarUsuario.jsp");

		view.forward(request, response);

	}

}
