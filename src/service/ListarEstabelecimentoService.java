package service;

import java.util.ArrayList;

import model.Estabelecimento;
import dao.EstabelecimentoDAO;

public class ListarEstabelecimentoService {
	EstabelecimentoDAO dao;
	
	public ListarEstabelecimentoService(){
		dao = new EstabelecimentoDAO();
	}
	public ArrayList<Estabelecimento> listarEstabelecimentos(){
		return dao.listarEstabelecimentos();
	}
	public ArrayList<Estabelecimento> listarEstabelecimentos(String chave){
		return dao.listarEstabelecimentos(chave);
	}

}
