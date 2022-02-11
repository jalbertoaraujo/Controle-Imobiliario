package br.com.controle.imobiliario.controler;

public class Imoveis {
	
	private Integer id_imoveis;
	private String usuario;
	private String empreendimento;
	private String descricao;
	private String endereço;
	private Double valorimovel;
	private String tipo;
	private String sequencial;
	private String caracteristicas;
	private String area;
	private String registro;
	private String cartorio;
	private String cidade;
	private String estado;
	private String codigo;
	
	public Integer getId_imoveis() {
		return id_imoveis;
	}
	public void setId_imoveis(Integer id_imoveis) {
		this.id_imoveis = id_imoveis;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmpreendimento() {
		return empreendimento;
	}
	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public Double getValorimovel() {
		return valorimovel;
	}
	public void setValorimovel(Double valorimovel) {
		this.valorimovel = valorimovel;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSequencial() {
		return sequencial;
	}
	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getCartorio() {
		return cartorio;
	}
	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
	
	public Imoveis(Integer id_imoveis, String usuario, String empreendimento, String descricao, String endereço,
			Double valorimovel, String tipo, String sequencial, String caracteristicas, String area, String registro,
			String cartorio, String cidade, String estado, String codigo) {
		super();
		this.id_imoveis = id_imoveis;
		this.usuario = usuario;
		this.empreendimento = empreendimento;
		this.descricao = descricao;
		this.endereço = endereço;
		this.valorimovel = valorimovel;
		this.tipo = tipo;
		this.sequencial = sequencial;
		this.caracteristicas = caracteristicas;
		this.area = area;
		this.registro = registro;
		this.cartorio = cartorio;
		this.cidade = cidade;
		this.estado = estado;
		this.codigo = codigo;
	}	
	
	@Override
	public String toString() {
		return "Imoveis [id_imoveis=" + id_imoveis + ", usuario=" + usuario + ", empreendimento=" + empreendimento
				+ ", descricao=" + descricao + ", endereço=" + endereço + ", valorimovel=" + valorimovel + ", tipo="
				+ tipo + ", sequencial=" + sequencial + ", caracteristicas=" + caracteristicas + ", area=" + area
				+ ", registro=" + registro + ", cartorio=" + cartorio + ", cidade=" + cidade + ", estado=" + estado + ", codigo=" + codigo
				+ "]";
	}
	
	public Imoveis(int int1, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public Imoveis() {
		// TODO Auto-generated constructor stub
	}
	
}
