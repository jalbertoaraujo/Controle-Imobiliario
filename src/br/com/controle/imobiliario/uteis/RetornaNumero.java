package br.com.controle.imobiliario.uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import br.com.controle.imobiliario.view.GerarCodigo;

public class RetornaNumero {

	public void retornanumero() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://Localhost:5432/ControleImobiliario",
					"postgres", "admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select count (codimovel) as quantidade from imoveis where codimovel like '"
					+ GerarCodigo.cbcodigocidade.getSelectedItem() + "%'");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {

				GerarCodigo.tfcodidimovel.setText(rs.getString("quantidade"));
				
				int i = Integer.parseInt(GerarCodigo.tfcodidimovel.getText());
				String formatted = String.format("%03d",i);
				GerarCodigo.tfcodidimovel.setText(formatted);
				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
