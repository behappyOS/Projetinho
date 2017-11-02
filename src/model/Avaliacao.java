package model;

public class Avaliacao {

	private int idAvaliacao;
	private double mediaAvaliacao;
	public Estabelecimento estabelecimento = new Estabelecimento();
	public Usuario usuario = new Usuario();
	
	public Avaliacao (){
		
	}
	
	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}

	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}


}
