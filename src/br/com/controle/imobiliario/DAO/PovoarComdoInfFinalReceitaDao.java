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

public class PovoarComdoInfFinalReceitaDao {
	
	private Connection connection;

	public PovoarComdoInfFinalReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Receita> dados = new ArrayList<Receita>();

		String sql = "SELECT DISTINCT periodo FROM receita ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				Estatisticas.cbinffinal.addItem(rs.getString("periodo"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
