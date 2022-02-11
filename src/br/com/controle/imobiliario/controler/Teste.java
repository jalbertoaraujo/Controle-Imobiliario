package br.com.controle.imobiliario.controler;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		
		Connection connection = new ConnectionFactory().getConnection();
		JOptionPane.showMessageDialog(null, "Conexão estabelecida com Sucesso");

	}

}
