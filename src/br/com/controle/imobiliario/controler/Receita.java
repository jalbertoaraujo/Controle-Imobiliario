package br.com.controle.imobiliario.controler;

public class Receita {
	
	private Integer id_receita;
	private String periodo;
	private String unidade;
	private String nome;
	private Double valor;
	private String obs_receita;	
	private String empreendimento;
	private String competencia;
	private String datareceita;
	
	public Integer getId_receita() {
		return id_receita;
	}
	public void setId_receita(Integer id_receita) {
		this.id_receita = id_receita;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getObs_receita() {
		return obs_receita;
	}
	public void setObs_receita(String obs_receita) {
		this.obs_receita = obs_receita;
	}
	public String getEmpreendimento() {
		return empreendimento;
	}
	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	public String getDatareceita() {
		return datareceita;
	}
	public void setDatareceita(String datareceita) {
		this.datareceita = datareceita;
	}	

	public Receita(Integer id_receita, String periodo, String unidade, String nome, Double valor, String obs_receita,
			String empreendimento, String competencia, String datareceita) {
		super();
		this.id_receita = id_receita;
		this.periodo = periodo;
		this.unidade = unidade;
		this.nome = nome;
		this.valor = valor;
		this.obs_receita = obs_receita;
		this.empreendimento = empreendimento;
		this.competencia = competencia;
		this.datareceita = datareceita;
	}	
	
	@Override
	public String toString() {
		return "Receita [id_receita=" + id_receita + ", periodo=" + periodo + ", unidade=" + unidade + ", nome=" + nome
				+ ", valor=" + valor + ", obs_receita=" + obs_receita + ", empreendimento=" + empreendimento
				+ ", competencia=" + competencia + ", datareceita=" + datareceita + "]";
	}
	
	public Receita() {
		// TODO Auto-generated constructor stub
	}
}
