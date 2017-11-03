package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estabelecimento;
import service.EstabelecimentoService;

public class VisualizarEstabelecimento implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdEst = request.getParameter("idEst");
		String pNomeFantasia = request.getParameter("nomeFantasia");
		String pEndereco = request.getParameter("endereco");
		String pCategoria = request.getParameter("categoria");
		int idEst = -1;
		try {
			idEst = Integer.parseInt(pIdEst);
		} catch (NumberFormatException e) {

		}
		int categoria = -1;
		try {
			categoria = Integer.parseInt(pCategoria);
		} catch (NumberFormatException e) {

		}

		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setIdEst(idEst);
		estabelecimento.setNomeFantasia(pNomeFantasia);
		estabelecimento.setEndereco(pEndereco);
		estabelecimento.setCategoria(categoria);
		EstabelecimentoService es = new EstabelecimentoService();
		
		RequestDispatcher view = null;
		
		System.out.println(estabelecimento);
		estabelecimento = es.carregar(estabelecimento.getIdEst());
		request.setAttribute("Estabelecimento", estabelecimento);
		view = request.getRequestDispatcher("VisualizarEstabelecimento.jsp");

		view.forward(request, response);

	}

}
