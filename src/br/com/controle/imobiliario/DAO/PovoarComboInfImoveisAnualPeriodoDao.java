package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.CadastrarReceita;
import br.com.controle.imobiliario.view.InfImoveisDespesaGeralImovel;

public class PovoarComboInfImoveisAnualPeriodoDao {
	
	private Connection connection;

	public PovoarComboInfImoveisAnualPeriodoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();

		String sql = "SELECT DISTINCT descricao FROM imoveis WHERE empreendimento = '"+InfImoveisDespesaGeralImovel.cbcadnovadespesaempreendimentoperiodo.getSelectedItem()+"' ORDER BY descricao ASC";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				InfImoveisDespesaGeralImovel.cbcadnovadespesaperiodo.addItem(rs.getString("descricao"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
