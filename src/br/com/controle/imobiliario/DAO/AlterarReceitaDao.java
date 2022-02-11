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
import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarDespesa;
import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.AlterarReceita;
import br.com.controle.imobiliario.view.CadastrarDespesa;

public class AlterarReceitaDao {

	private Connection connection;

	public AlterarReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public void listar() {

		List<Receita> dados = new ArrayList<Receita>();

		String sql = "UPDATE receita SET nome = '" + AlterarReceita.cbnomereceitaalterar.getSelectedItem()
				+ "', valor = '" + AlterarReceita.tfvalorreceita.getText() + "', competencia = '"
				+ AlterarReceita.cbcompetenciareceita.getSelectedItem() + "', obs_receita = '"
				+ AlterarReceita.tfobsreceita.getText() + "' WHERE id_receita = '"
				+ AlterarReceita.tfidreceitaalterar.getText() + "'";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse retorna Conexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "RECEITA ALTERADA COM SUCESSO");
			AlterarReceita.tfvalorreceita.setText("");
			AlterarReceita.tfobsreceita.setText("");
			// throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
