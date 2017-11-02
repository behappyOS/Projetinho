package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class CriarUsuario implements Command {

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

		Usuario Usuario = new Usuario();
		Usuario.setIdUsuario(idUsuario);
		Usuario.setNome(pNome);
		Usuario.setEmail(pEmail);
		Usuario.setCelular(pCelular);
		Usuario.setLogin(pLogin);
		Usuario.setSenha(pSenha);
		
		UsuarioService us = new UsuarioService();
		us.criar(Usuario);
		Usuario = us.carregar(Usuario.getIdUsuario());
		
		request.setAttribute("Usuario", Usuario);
		RequestDispatcher view = request.getRequestDispatcher("CriarUsuario.jsp");
		view.forward(request, response);
		
		
	}

}
