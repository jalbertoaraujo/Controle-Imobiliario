package br.com.controle.imobiliario.controler;

public class SaldoAnual {

	private int id_saldoanual;
	private String empreendimento;
	private String unidade;
	private String periodo;
	private String totalreceita;
	private String totaldespesa;
	private String saldo;
	private String codigo;

	public int getId_saldoanual() {
		return id_saldoanual;
	}

	public void setId_saldoanual(int id_saldoanual) {
		this.id_saldoanual = id_saldoanual;
	}

	public String getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTotalreceita() {
		return totalreceita;
	}

	public void setTotalreceita(String totalreceita) {
		this.totalreceita = totalreceita;
	}

	public String getTotaldespesa() {
		return totaldespesa;
	}

	public void setTotaldespesa(String totaldespesa) {
		this.totaldespesa = totaldespesa;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public SaldoAnual(int id_saldoanual, String empreendimento, String unidade, String periodo, String totalreceita,
			String totaldespesa, String saldo, String codigo) {
		super();
		this.id_saldoanual = id_saldoanual;
		this.empreendimento = empreendimento;
		this.unidade = unidade;
		this.periodo = periodo;
		this.totalreceita = totalreceita;
		this.totaldespesa = totaldespesa;
		this.saldo = saldo;
		this.codigo = codigo;
	}

	public SaldoAnual() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SaldoAnual [id_saldoanual=" + id_saldoanual + ", empreendimento=" + empreendimento + ", unidade="
				+ unidade + ", periodo=" + periodo + ", totalreceita=" + totalreceita + ", totaldespesa=" + totaldespesa
				+ ", saldo=" + saldo + ", codigo=" + codigo + "]";
	}

}
