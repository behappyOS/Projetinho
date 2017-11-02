package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Avaliacao;
import service.AvaliacaoService;

public class VisualizarAvaliacao implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdAvaliacao = request.getParameter("IdAvaliacao");

		int IdAvaliacao = -1;
		try {
			IdAvaliacao = Integer.parseInt(pIdAvaliacao);
		} catch (NumberFormatException e) {

		}
		

		Avaliacao Avaliacao = new Avaliacao();
		Avaliacao.setIdAvaliacao(IdAvaliacao);

		AvaliacaoService cs = new AvaliacaoService();
		
		RequestDispatcher view = null;

		Avaliacao = cs.carregar(Avaliacao.getIdAvaliacao());
		request.setAttribute("Avaliacao", Avaliacao);
		view = request.getRequestDispatcher("VisualizarAvaliacao.jsp");

		view.forward(request, response);

	}

}
