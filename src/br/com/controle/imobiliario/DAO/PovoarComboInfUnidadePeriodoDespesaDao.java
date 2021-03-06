package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Estatisticas;

public class PovoarComboInfUnidadePeriodoDespesaDao {
	
	private Connection connection;

	public PovoarComboInfUnidadePeriodoDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Receita> dados = new ArrayList<Receita>();

		String sql = "SELECT DISTINCT descricao FROM imoveis ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				Estatisticas.cbinfunidadeperiododespesa.addItem(rs.getString("descricao"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
