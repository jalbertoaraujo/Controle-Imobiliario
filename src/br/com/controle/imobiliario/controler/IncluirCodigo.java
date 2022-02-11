package br.com.controle.imobiliario.controler;

public class IncluirCodigo {
	
	private Integer id_desccodigo;
	private String letras;
	
	public Integer getId_desccodigo() {
		return id_desccodigo;
	}
	public void setId_desccodigo(Integer id_desccodigo) {
		this.id_desccodigo = id_desccodigo;
	}
	public String getLetras() {
		return letras;
	}
	public void setLetras(String letras) {
		this.letras = letras;
	}
	
	public IncluirCodigo(Integer id_desccodigo, String letras) {
		super();
		this.id_desccodigo = id_desccodigo;
		this.letras = letras;
	}
	
	@Override
	public String toString() {
		return "IncluirCodigo [id_desccodigo=" + id_desccodigo + ", letras=" + letras + "]";
	}
}
