package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.view.Entrar;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.esqueciSenha;
import br.com.controle.imobiliario.view.principal;

import br.com.controle.imobiliario.model.ConnectionFactory;

public class AcessarDao {
	
	private Connection connection;
	
	public AcessarDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void acessar() {
		String sql = "select (usuario,senha) from usuario where usuario = '"
				+ Login.cbusuario.getSelectedItem()
				+ "' and senha = '" + Login.tfsenha.getText()
				+ "'";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			if (rs.next()) {

//				String exp = rs.getString("senha"); // se for Varchar ou char usa rs.getString
//
//				String exp1 = rs.getString("usuario"); // se for Varchar ou char usa rs.getString				
				
//				principal pri = new principal();
//				pri.setVisible(true);
				Entrar.menucadastro.setEnabled(true);
				Entrar.menuinformacoes.setEnabled(true);
				Entrar.menuutilidade.setEnabled(true);
		    	Entrar.menuRelatorios.setEnabled(true);
				Entrar.menuAcessar.setEnabled(false);
				Entrar.lblentrarlogado.setText(Login.cbusuario.getSelectedItem().toString());				
			
			} else {
				JOptionPane.showMessageDialog(null,
						"SENHA INCORRETA");
				
				Login.tfsenha.setText("");
				Login.tfsenha.requestFocus();
				Entrar.menucadastro.setEnabled(false);
				Entrar.menuinformacoes.setEnabled(false);
				Entrar.menuutilidade.setEnabled(false);
				Entrar.menuRelatorios.setEnabled(false);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
