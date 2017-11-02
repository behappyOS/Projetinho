package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import service.ListarAvaliacoesService;

public class ListarAvaliacoesBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ListarAvaliacoesService listar = new ListarAvaliacoesService();
		ArrayList<Avaliacao> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = listar.listarAvaliacoes(chave);
		} else {
			lista = listar.listarAvaliacoes();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarAvaliacoes.jsp");
		dispatcher.forward(request, response);
	}
}
