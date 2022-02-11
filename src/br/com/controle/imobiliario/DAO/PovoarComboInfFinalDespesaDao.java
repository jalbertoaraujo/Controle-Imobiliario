package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Despesa;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Estatisticas;

public class PovoarComboInfFinalDespesaDao {
	
	private Connection connection;

	public  PovoarComboInfFinalDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Despesa> dados = new ArrayList<Despesa>();

		String sql = "SELECT DISTINCT periodo FROM receita ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				Estatisticas.cbinffinaldespesa.addItem(rs.getString("periodo"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
