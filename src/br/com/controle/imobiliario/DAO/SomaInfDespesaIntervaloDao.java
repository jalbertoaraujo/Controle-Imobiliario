package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.Estatisticas;

public class SomaInfDespesaIntervaloDao {

private Connection connection;
	
	public SomaInfDespesaIntervaloDao(){
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void Listar() {

		List<Despesa> dados = new ArrayList<Despesa>();
		
		DefaultTableModel tab = (DefaultTableModel) EstatisticaImoveis.tabelaestatisticadespesaimovel.getModel();
		
		String sql = "SELECT SUM (valor) AS total FROM despesa WHERE periodo = '"
				+ EstatisticaImoveis.cbinfinicialdespesa.getSelectedItem() + "' AND unidade = '"
				+ EstatisticaImoveis.tfestatisticaunidade.getText() + "'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				EstatisticaImoveis.tftotaldespesa.setText(rs.getString("total"));
							
			}			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
}
