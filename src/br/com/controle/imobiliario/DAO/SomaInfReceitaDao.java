package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.InfReceitaGeral;

public class SomaInfReceitaDao {

	private Connection connection;

	public SomaInfReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Receita> dados = new ArrayList<Receita>();

		DefaultTableModel tab = (DefaultTableModel) InfReceitaGeral.tabelasaldoanual.getModel();

		String sql = "SELECT SUM (valor) AS total FROM receita WHERE empreendimento = '"
				+ InfReceitaGeral.tfempreendimentoreceitageral.getText() + "' AND unidade = '"
				+ InfReceitaGeral.tfunidadereceitageral.getText() + "'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				InfReceitaGeral.tftotalgeralreceita.setText(rs.getString("total"));				
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
