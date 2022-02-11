package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.IncluirNovaReceita;

public class IncluirNovaReceitaDao {

	private Connection connection;

	public IncluirNovaReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void incluirReceita(IncluirNovaReceita ir) {

		String sql = " INSERT INTO descreceita (descricao) VALUES (?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, IncluirNovaReceita.tfincluirnovareceita.getText());			
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "NOVO TIPO DE RECEITA CADASTRADA COM SUCESSO");
			IncluirNovaReceita.tfincluirnovareceita.setText("");
			IncluirNovaReceita.tfincluirnovareceita.requestFocus();
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}

	}

}
