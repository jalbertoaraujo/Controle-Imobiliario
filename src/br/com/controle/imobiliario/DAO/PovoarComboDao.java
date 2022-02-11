package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Usuario;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.principal;

public class PovoarComboDao {

	private Connection connection;

	public PovoarComboDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Usuario> dados = new ArrayList<Usuario>();

		String sql = "SELECT usuario FROM usuario ORDER BY id_usuario";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Login.cbusuario.addItem(rs.getString("usuario"));

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}