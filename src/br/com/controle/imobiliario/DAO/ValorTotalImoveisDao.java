package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.principal;

public class ValorTotalImoveisDao {
	
	private Connection connection;

	public ValorTotalImoveisDao () {
		
		this.connection = new ConnectionFactory().getConnection();
	}	

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();			
		
		String sql = "SELECT valor FROM imoveis WHERE descricao = '"+ EstatisticaImoveis.tfestatisticaunidade.getText()
				+ "'";

		try {
			
			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while(rs.next()) {
				
				EstatisticaImoveis.tfinfvalorimovel.setText(rs.getString("valor"));			
				
			}			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
