package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarReceita;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.GerarCodigo;

public class ListarNumeroDao {

	private Connection connection;

	public ListarNumeroDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();

		

		String sql = "select count (codimovel) as quantidade from imoveis where codimovel like '"
				+ GerarCodigo.cbcodigocidade.getSelectedItem() + "%'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse
																		// retornaConexao
																		// está
																		// tratando
																		// da
																		// conexão
																		// com o
																		// bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				GerarCodigo.tfcodidimovel.setText(rs.getString("quantidade"));

				int i = Integer.parseInt(GerarCodigo.tfcodidimovel.getText());
				String formatted = String.format("%03d", i);
				GerarCodigo.tfcodidimovel.setText(formatted);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}