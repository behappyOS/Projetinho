package service;

import java.util.ArrayList;

import model.Avaliacao;
import dao.AvaliacaoDAO;

public class ListarAvaliacoesService {
	AvaliacaoDAO dao;
	
	public ListarAvaliacoesService(){
		dao = new AvaliacaoDAO();
	}
	public ArrayList<Avaliacao> listarAvaliacoes(){
		return dao.listarAvaliacoes();
	}
	public ArrayList<Avaliacao> listarAvaliacoes(String chave){
		return dao.listarAvaliacoes(chave);
	}

}
