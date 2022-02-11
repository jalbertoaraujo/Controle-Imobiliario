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
import br.com.controle.imobiliario.view.AlterarImoveis;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.principal;

public class ListaImoveisAlterarDao {		
	
	private Connection connection;

	public ListaImoveisAlterarDao() {
		
		this.connection = new ConnectionFactory().getConnection();
	}	

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();				
		
		String sql = "SELECT * FROM imoveis WHERE codimovel = '"+ AlterarImoveis.tfcodalterar.getText()
				+ "'";
		try {
			
			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while(rs.next()) {
				
				AlterarImoveis.tfempreendimentoalterar.setText((rs.getString("empreendimento")));
				AlterarImoveis.tfdescricaoalterar.setText((rs.getString("descricao")));
				AlterarImoveis.tfendereçoalterar.setText((rs.getString("endereco")));
				AlterarImoveis.tfcidadealterar.setText((rs.getString("cidade")));
				AlterarImoveis.cbestadoalterar.setSelectedItem((rs.getString("estado")));
				AlterarImoveis.tfvaloralterar.setText((rs.getString("valor")));
				AlterarImoveis.tfsequencialalterar.setText((rs.getString("sequencial")));
				AlterarImoveis.cbtipoalterar.setSelectedItem((rs.getString("tipo")));
				AlterarImoveis.tfcaracteristicaalterar.setText((rs.getString("caracteristica")));
				AlterarImoveis.tfareaalterar.setText((rs.getString("area")));
				AlterarImoveis.tfregistroalterar.setText((rs.getString("registro")));
				AlterarImoveis.tfcartorioalterar.setText((rs.getString("cartorio")));
				AlterarImoveis.tfcodalterar.setText((rs.getString("codimovel")));
			}			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
