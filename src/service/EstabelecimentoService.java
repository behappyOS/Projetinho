package service;

import model.Estabelecimento;

import java.util.ArrayList;

import dao.EstabelecimentoDAO;


public class EstabelecimentoService {
	EstabelecimentoDAO dao = new EstabelecimentoDAO();
	
	public int criar(Estabelecimento Estabelecimento) {
		return dao.criar(Estabelecimento);
	}
	
	public void atualizar(Estabelecimento Estabelecimento){
		dao.atualizar(Estabelecimento);
	}
	
	public void excluir(int idEst){
		dao.excluir(idEst);
	}
	
	public Estabelecimento carregar(int idEst){
		return dao.carregar(idEst);
	}
	
	public ArrayList<Estabelecimento> listarEstabelecimentos(){
		return dao.listarEstabelecimentos();
	}
	
	public ArrayList<Estabelecimento> listarEstabelecimentos(String chave){
		return dao.listarEstabelecimentos(chave);
	}

}
