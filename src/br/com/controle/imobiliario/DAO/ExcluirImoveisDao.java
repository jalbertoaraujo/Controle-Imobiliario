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
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarImoveis;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.principal;

public class ExcluirImoveisDao {

	private Connection connection;

	public ExcluirImoveisDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {
		int jcd = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ESTE IM�VEL ?");

		if (jcd == JOptionPane.YES_OPTION) {

			JOptionPane.showMessageDialog(null, "IM�VEL SER� EXCLU�DO!");

			List<Imoveis> dados = new ArrayList<Imoveis>();

			String sql = "DELETE FROM imoveis WHERE id_imoveis = '" + AlterarImoveis.tfcodalterar.getText() + "'";

			try {
				PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est� tratando da conex�o com o bd.
				ResultSet rs = prep.executeQuery();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "IM�VEL EXCLU�DO COM SUCESSO");
				AlterarImoveis.tfcodalterar.setText("");
				AlterarImoveis.tfempreendimentoalterar.setText("");
				AlterarImoveis.tfdescricaoalterar.setText("");
				AlterarImoveis.tfendere�oalterar.setText("");
				AlterarImoveis.tfvaloralterar.setText("");
				AlterarImoveis.tfsequencialalterar.setText("");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (jcd == JOptionPane.NO_OPTION) {

			JOptionPane.showMessageDialog(null, "VERIFIQUE A NECESSIDADE DE EXCLUIR O IM�VEL");
		}
		if (jcd == JOptionPane.CLOSED_OPTION) {

		}

	}

}
