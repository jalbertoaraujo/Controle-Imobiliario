package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarReceita;
import br.com.controle.imobiliario.view.GerarCodigo;

public class CadastrarCodigoDao {

	private Connection connection;

	public CadastrarCodigoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarCodigo(GerarCodigo gercod) {

		String sql = "SELECT * FROM desccodigo WHERE letras = '" + GerarCodigo.tfcodigo.getText() + "'";

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

			if (rs.next()) {

				JOptionPane.showMessageDialog(null, "REGISTRO JÁ EXITE");
				GerarCodigo.tfcodigo.setText("");
				GerarCodigo.tfcodcidade.setText("");
				GerarCodigo.tfcodcidade.requestFocus();
			} else {

				String sql1 = " INSERT INTO desccodigo (letras) VALUES (?)";

				try {
					PreparedStatement ps = connection.prepareStatement(sql1);
					ps.setString(1, GerarCodigo.tfcodigo.getText());
					// ps.setString(2, GerarCodigo.tfcodigo.getText());
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null, "NOVO CÓDIGO CADASTRADO COM SUCESSO");
					GerarCodigo.tfcodcidade.setText("");
				} catch (SQLException erro) {
					throw new RuntimeException(erro);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}