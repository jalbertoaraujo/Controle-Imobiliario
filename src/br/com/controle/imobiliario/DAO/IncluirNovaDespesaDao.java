package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;

import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.IncluirNovaDespesa;

public class IncluirNovaDespesaDao {

	private Connection connection;

	public IncluirNovaDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void incluirDespesa(IncluirNovaDespesa id) {

		String sql = " INSERT INTO descdespesa (descricao) VALUES (?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, IncluirNovaDespesa.tfincluirnovadespesa.getText());			
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "NOVO TIPO DE DESPESA CADASTRADA COM SUCESSO");
			IncluirNovaDespesa.tfincluirnovadespesa.setText("");
			IncluirNovaDespesa.tfincluirnovadespesa.requestFocus();
			CadastrarDespesa.cbnomedespesa.removeAllItems();
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}

	}

}
