package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.InfImovel;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.principal;

public class ListaEstatisticaImoveisDao {		
	
	private Connection connection;

	public ListaEstatisticaImoveisDao() {
		
		this.connection = new ConnectionFactory().getConnection();
	}	

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();
		
		DefaultTableModel tab = (DefaultTableModel) InfImovel.tabelainfimoveis.getModel();			
		
		String sql = "SELECT * FROM imoveis order by empreendimento asc";

		try {
			
			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while(rs.next()) {
				
				Imoveis imoveis = new Imoveis();
				
				imoveis.setId_imoveis(rs.getInt("id_imoveis"));
				imoveis.setUsuario(rs.getString("usuario"));
				imoveis.setEmpreendimento(rs.getString("empreendimento"));
				imoveis.setDescricao(rs.getString("descricao"));
				imoveis.setSequencial(rs.getString("sequencial"));
				imoveis.setEndereço(rs.getString("endereco"));
				imoveis.setValorimovel(rs.getDouble("valor"));
				imoveis.setTipo(rs.getString("tipo"));
				imoveis.setCaracteristicas(rs.getString("caracteristica"));
				imoveis.setArea(rs.getString("area"));
				imoveis.setRegistro(rs.getString("registro"));
				imoveis.setCartorio(rs.getString("cartorio"));
				imoveis.setCidade(rs.getString("cidade"));
				imoveis.setEstado(rs.getString("estado"));
				imoveis.setCodigo(rs.getString("codimovel"));
				
				dados.add(imoveis);				
				
			}			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (Imoveis temp : dados) {
			Object[] linha = {temp.getCodigo(), temp.getEmpreendimento(), temp.getDescricao(), temp.getCidade(), temp.getEstado()};
			tab.addRow(linha);
			
			if(dados.isEmpty()){
				JOptionPane.showMessageDialog(null, "IMÓVEIS NÃO CADASTRADOS");
			}
			
		}		
		
	}	
}
