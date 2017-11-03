package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Estabelecimento;
import service.EstabelecimentoService;
import service.UsuarioService;

public class CriarEstabelecimento implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pidEst = request.getParameter("idEst");
		String pNomeFantasia = request.getParameter("nomeFantasia");
		String pEndereco = request.getParameter("endereco");
		String pCategoria = request.getParameter("categoria");
		
		
		System.out.println(pCategoria);
		System.out.println(pNomeFantasia);
		System.out.println(pEndereco);
		System.out.println(pCategoria);
		
		int idEst = -1;
		try {
			idEst = Integer.parseInt(pidEst);
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
		HttpSession session = request.getSession();
		System.out.println(estabelecimento);
		es.criar(estabelecimento);
		
		estabelecimento = es.carregar(estabelecimento.getIdEst());
		request.setAttribute("Estabelecimento", estabelecimento);
		//RequestDispatcher view = request.getRequestDispatcher("CriarEstabelecimento.jsp");
		//view.forward(request, response);
		
		
		ArrayList<Estabelecimento> lista = new ArrayList<>();
		lista.add(estabelecimento);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("CriarEstabelecimento.jsp");
		view.forward(request, response);

	}

	public int busca(Estabelecimento estabelecimento, ArrayList<Estabelecimento> lista) {
		Estabelecimento to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdEst() == estabelecimento.getIdEst()) {
				return i;
			}
		}
		return -1;
	}

}
