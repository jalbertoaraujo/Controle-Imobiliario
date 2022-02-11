package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.esqueciSenha;
import br.com.controle.imobiliario.view.novoUsuario;
import br.com.controle.imobiliario.controler.Usuario;
import br.com.controle.imobiliario.interfaces.*;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionaUsuario(novoUsuario novousuario) {

		String sql = "INSERT INTO usuario (usuario, senha, repetesenha, dicadesenha) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, novoUsuario.tfnovousuario.getText());
			ps.setString(2, novoUsuario.tfnovasenha.getText());
			ps.setString(3, novoUsuario.tfrepetesenha.getText());
			ps.setString(4, novoUsuario.tfdicadesenha.getText());
			ps.execute();
			ps.close();

		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}

	}

	public void buscasenha() {
		String sql = "select (senha) from usuario where usuario = '"
				+ esqueciSenha.tflembrausuario.getText()
				+ "' and dicadesenha = '" + esqueciSenha.tflembradica.getText()
				+ "'";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			if (rs.next()) {

				String exp = rs.getString("senha"); // se for Varchar ou char
													// usa rs.getString

				esqueciSenha.lblembrasenha.setText(exp);

			} else {
				JOptionPane.showMessageDialog(null,
						"Usuário ou Dica de Senha informados Incorretamente");
				esqueciSenha.tflembrausuario.setText("");
				esqueciSenha.tflembradica.setText("");
				esqueciSenha.tflembrausuario.requestFocus();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
