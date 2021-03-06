package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.Estatisticas;

public class SomaInfReceitaIntervaloDao {
	
	private Connection connection;

	public SomaInfReceitaIntervaloDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Receita> dados = new ArrayList<Receita>();

		DefaultTableModel tab = (DefaultTableModel) EstatisticaImoveis.tabelaestatisticareceitaimovel.getModel();

		String sql = "SELECT SUM (valor) AS total FROM receita WHERE periodo = '"
				+ EstatisticaImoveis.cbinfinicialdespesa.getSelectedItem() + "' AND empreendimento =  '"+EstatisticaImoveis.tfempreendimentoestatisticaimovel.getText()+"' AND unidade = '"
				+ EstatisticaImoveis.tfestatisticaunidade.getText() + "'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				EstatisticaImoveis.tftotalreceita.setText(rs.getString("total"));				
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
