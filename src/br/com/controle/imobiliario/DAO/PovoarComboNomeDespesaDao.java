package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Despesa;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.Estatisticas;

public class PovoarComboNomeDespesaDao {

	private Connection connection;

	public PovoarComboNomeDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Despesa> dados = new ArrayList<Despesa>();

		String sql = "SELECT DISTINCT descricao FROM descdespesa order by descricao ASC ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est� tratando da conex�o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				CadastrarDespesa.cbnomedespesa.addItem(rs.getString("descricao"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}

}
