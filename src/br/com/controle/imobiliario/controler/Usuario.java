package br.com.controle.imobiliario.controler;

public class Usuario {
	
	
	private Integer id_usuario;
	private String nome;
	private String senha;
	private String repetesenha;
	private String dica;
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public String setSenha(String senha) {
		return this.senha = senha;
	}
	public String getRepetesenha() {
		return repetesenha;
	}
	public void setRepetesenha(String repetesenha) {
		this.repetesenha = repetesenha;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	
	public Usuario(Integer id_usuario, String nome, String senha,
			String repetesenha, String dica) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.senha = senha;
		this.repetesenha = repetesenha;
		this.dica = dica;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome=" + nome
				+ ", senha=" + senha + ", repetesenha=" + repetesenha
				+ ", dica=" + dica + "]";
	}
	
}
