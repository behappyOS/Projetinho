package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import service.AvaliacaoService;

public class EditarAvaliacao implements Command {

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
		HttpSession session = request.getSession();
		
		Avaliacao = cs.carregar(Avaliacao.getIdAvaliacao());
		request.setAttribute("Avaliacao", Avaliacao);
		view = request.getRequestDispatcher("AlterarAvaliacao.jsp");		
		
		view.forward(request, response);

	}

	public int busca(Avaliacao Avaliacao, ArrayList<Avaliacao> lista) {
		Avaliacao to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getIdAvaliacao() == Avaliacao.getIdAvaliacao()){
				return i;
			}
		}
		return -1;
	}

}
