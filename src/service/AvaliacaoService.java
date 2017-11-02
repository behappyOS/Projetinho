package service;

import model.Avaliacao;
import dao.AvaliacaoDAO;


public class AvaliacaoService {
	AvaliacaoDAO dao = new AvaliacaoDAO();
	
	public int criar(Avaliacao Avaliacao) {
		return dao.criar(Avaliacao);
	}
	
	public void atualizar(Avaliacao Avaliacao){
		dao.atualizar(Avaliacao);
	}
	
	public void excluir(int idAvaliacao){
		dao.excluir(idAvaliacao);
	}
	
	public Avaliacao carregar(int idAvaliacao){
		return dao.carregar(idAvaliacao);
	}

}
