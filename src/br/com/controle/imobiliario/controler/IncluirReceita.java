package br.com.controle.imobiliario.controler;

public class IncluirReceita {
	
	private Integer id_descreceita;
	private String descricao;
	
	public Integer getId_descreceita() {
		return id_descreceita;
	}
	public void setId_descreceita(Integer id_descreceita) {
		this.id_descreceita = id_descreceita;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public IncluirReceita(Integer id_descreceita, String descricao) {
		super();
		this.id_descreceita = id_descreceita;
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "IncluirReceita [id_descreceita=" + id_descreceita + ", descricao=" + descricao + "]";
	}
	

}
