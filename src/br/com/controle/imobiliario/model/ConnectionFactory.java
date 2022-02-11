package br.com.controle.imobiliario.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://192.168.254.17/ControleImobiliario";
	private String usuario = "postgres";
	private String senha = "admin";

	public Connection getConnection() {

		try {

			return DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException erro) {
			
			throw new RuntimeException(erro);
		}

	}
}
