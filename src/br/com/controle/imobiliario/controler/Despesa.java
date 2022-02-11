package br.com.controle.imobiliario.controler;

public class Despesa {
	
	private Integer id_despesa;
	private String periodo;
	private String unidade;
	private String nome;
	private Double valor;
	private String obs_despesa;	
	private String empreendimento;
	private String competencia;
	private String datadespesa;	

	
	public Integer getId_despesa() {
		return id_despesa;
	}
	public void setId_despesa(Integer id_despesa) {
		this.id_despesa = id_despesa;
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
	public String getObs_despesa() {
		return obs_despesa;
	}
	public void setObs_despesa(String obs_despesa) {
		this.obs_despesa = obs_despesa;
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
	public String getDatadespesa() {
		return datadespesa;
	}
	public void setDatadespesa(String datadespesa) {
		this.datadespesa = datadespesa;
	}
	
	public Despesa(Integer id_despesa, String periodo, String unidade, String nome, Double valor, String obs_despesa,
			String empreendimento, String competencia, String datadespesa) {
		super();
		this.id_despesa = id_despesa;
		this.periodo = periodo;
		this.unidade = unidade;
		this.nome = nome;
		this.valor = valor;
		this.obs_despesa = obs_despesa;
		this.empreendimento = empreendimento;
		this.competencia = competencia;
		this.datadespesa = datadespesa;
	}	
	
	@Override
	public String toString() {
		return "Despesa [id_despesa=" + id_despesa + ", periodo=" + periodo + ", unidade=" + unidade + ", nome=" + nome
				+ ", valor=" + valor + ", obs_despesa=" + obs_despesa + ", empreendimento=" + empreendimento
				+ ", competencia=" + competencia + ", datadespesa=" + datadespesa + "]";
	}
	public Despesa() {
		// TODO Auto-generated constructor stub
	}

}
