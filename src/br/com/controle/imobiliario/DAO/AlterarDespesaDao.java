package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.controler.IncluirDespesa;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarDespesa;
import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.CadastrarDespesa;

public class AlterarDespesaDao {

	private Connection connection;

	public AlterarDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public void listar() {

		List<Despesa> dados = new ArrayList<Despesa>();

		String sql = "UPDATE despesa SET nome = '" + AlterarDespesa.cbnomedespesaalterar.getSelectedItem()
				+ "', valor = '" + AlterarDespesa.tfvalordespesa.getText() + "', competencia = '"
				+ AlterarDespesa.cbcompetenciadespesa.getSelectedItem() + "', obs_despesa = '"
				+ AlterarDespesa.tfobsdespesa.getText() + "' WHERE id_despesa = '"
				+ AlterarDespesa.tfiddespesaalterar.getText() + "'";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse retorna Conexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "DESPESA ALTERADA COM SUCESSO");
			AlterarDespesa.tfvalordespesa.setText("");
			AlterarDespesa.tfobsdespesa.setText("");
			// throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
