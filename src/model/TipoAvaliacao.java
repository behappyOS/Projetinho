package model;

public class TipoAvaliacao {
	private int idTipo;
	private String tipoAvaliacao;
	private String observacao;
	
	public TipoAvaliacao() {
		
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public String getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	
	public void setTipoAvaliacao(String tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}