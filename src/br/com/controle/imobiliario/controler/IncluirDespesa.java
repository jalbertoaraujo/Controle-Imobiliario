package br.com.controle.imobiliario.controler;

public class IncluirDespesa {
	
	private Integer id_descdespesa;
	private String descricao;
	
	public Integer getId_descdespesa() {
		return id_descdespesa;
	}
	public void setId_descdespesa(Integer id_descdespesa) {
		this.id_descdespesa = id_descdespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public IncluirDespesa(Integer id_descdespesa, String descricao) {
		super();
		this.id_descdespesa = id_descdespesa;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "IncluirDespesa [id_descdespesa=" + id_descdespesa + ", descricao=" + descricao + "]";
	}	

}
