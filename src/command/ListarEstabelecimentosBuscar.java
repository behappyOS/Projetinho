package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Estabelecimento;
import service.ListarEstabelecimentoService;

public class ListarEstabelecimentosBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ListarEstabelecimentoService listar = new ListarEstabelecimentoService();
		ArrayList<Estabelecimento> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = listar.listarEstabelecimentos(chave);
		} else {
			lista = listar.listarEstabelecimentos();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEstabelecimentos.jsp");
		dispatcher.forward(request, response);
	}
}
