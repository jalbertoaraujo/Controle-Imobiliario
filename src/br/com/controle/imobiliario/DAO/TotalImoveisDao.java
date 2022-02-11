package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.principal;

public class TotalImoveisDao {

	private Connection connection;

	public TotalImoveisDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();

		//DefaultTableModel tab = (DefaultTableModel) principal.table.getModel();

		String sql = "select count (descricao) as quantidade from imoveis";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {				
				
				Estatisticas.tftotalimoveiscadastrados.setText(rs.getString("quantidade"));				
				
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
