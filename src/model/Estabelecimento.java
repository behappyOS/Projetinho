package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import service.EstabelecimentoService;

public class Estabelecimento {
	private int idEst;
	private String nomeFantasia;
	private String endereco;
	private int categoria;

	 Estabelecimento (int idEst, String nomeFantasia, String endereco, int categoria) {
		this.idEst = idEst;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.categoria = categoria;
	}
	
	public Estabelecimento() {
		
	}

	public int getIdEst() {
		return idEst;
	}

	public void setIdEst(int idEst) {
		this.idEst = idEst;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setCategoria(int categoria) {
		 this.categoria = categoria;
		
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	@Override
	public String toString() {
		return "Usuario [idEst=" + idEst + ", nomeFantasia=" + nomeFantasia + ", endereco=" + endereco + 
				", categoria=" + categoria + "]";
	}

	
	/*public static void main (String [] args) {
		Estabelecimento est = new Estabelecimento(4, "Belas artes", "Av Concolação com a Paulista", 2);
		EstabelecimentoService ests = new EstabelecimentoService();

		 * Como estava pegando o ID categoria
		Categoria cat = new Categoria();
		est.setNomeFantasia("Estabelecimento");
		est.setEndereco("Rua endereço, 123");
		cat.setIdCategoria(1);

		//ests.atualizar(est);
		//ests.excluir(1);
		//JOptionPane.showMessageDialog(null, "Foi");
		//est = ests.carregar(11);
		//JOptionPane.showMessageDialog(null, est.getIdEst() + est.getNomeFantasia() + est.getEndereco() + est.getIdCategoria());
		//
		ests.listarEstabelecimentos("q");
		ArrayList<Estabelecimento> lista = null;
		lista = ests.listarEstabelecimentos("q");
		for (Estabelecimento estao : lista) {
			System.out.println(estao.getNomeFantasia());
		}
		
	}		 */
	

}
