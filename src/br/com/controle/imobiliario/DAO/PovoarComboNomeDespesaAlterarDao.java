package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Despesa;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarDespesa;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.Estatisticas;

public class PovoarComboNomeDespesaAlterarDao {
	
	private Connection connection;

	public PovoarComboNomeDespesaAlterarDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Despesa> dados = new ArrayList<Despesa>();

		String sql = "SELECT descricao FROM descdespesa order by descricao ASC ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				AlterarDespesa.cbnomedespesaalterar.addItem(rs.getString("descricao"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
