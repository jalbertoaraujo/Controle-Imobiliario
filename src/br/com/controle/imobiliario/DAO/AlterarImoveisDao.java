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

public class AlterarImoveisDao {

	private Connection connection;

	public AlterarImoveisDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();

		String sql = "UPDATE imoveis SET empreendimento = '" + AlterarImoveis.tfempreendimentoalterar.getText()
				+ "', descricao = '" + AlterarImoveis.tfdescricaoalterar.getText() + "', endereco = '"
				+ AlterarImoveis.tfendere�oalterar.getText() + "', cidade = '"
				+ AlterarImoveis.tfcidadealterar.getText() + "',estado = '"
				+ AlterarImoveis.cbestadoalterar.getSelectedItem() + "', valor ='"
				+ AlterarImoveis.tfvaloralterar.getText() + "', tipo = '"
				+ AlterarImoveis.cbtipoalterar.getSelectedItem() + "', sequencial = '"
				+ AlterarImoveis.tfsequencialalterar.getText() + "', caracteristica = '"
				+ AlterarImoveis.tfcaracteristicaalterar.getText() + "', area = '"
				+ AlterarImoveis.tfareaalterar.getText() + "', registro = '"
				+ AlterarImoveis.tfregistroalterar.getText() + "', cartorio = '"
				+ AlterarImoveis.tfcartorioalterar.getText() + "' WHERE codimovel = '"
				+ AlterarImoveis.tfcodalterar.getText() + "'";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse retorna Conexao est� tratando da conex�o com o bd.
			ResultSet rs = prep.executeQuery();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "IM�VEL ALTERADO COM SUCESSO");
			AlterarImoveis.tfcodalterar.setText("");
			AlterarImoveis.tfempreendimentoalterar.setText("");
			AlterarImoveis.tfdescricaoalterar.setText("");
			AlterarImoveis.tfendere�oalterar.setText("");
			AlterarImoveis.tfvaloralterar.setText("");
			AlterarImoveis.tfsequencialalterar.setText("");

			// throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
