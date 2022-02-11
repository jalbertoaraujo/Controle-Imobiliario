package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.IncluirCodigo;
import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.controler.Usuario;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.GerarCodigo;

public class PovoarComboCodigoCidadeDao {

	private Connection connection;

	public PovoarComboCodigoCidadeDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<IncluirCodigo> dados = new ArrayList<IncluirCodigo>();

		String sql = "SELECT DISTINCT letras FROM desccodigo ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				GerarCodigo.cbcodigocidade.addItem(rs.getString("letras"));
			}			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
