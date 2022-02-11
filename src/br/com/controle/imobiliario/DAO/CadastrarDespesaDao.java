package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;

import br.com.controle.imobiliario.view.CadastrarDespesa;

public class CadastrarDespesaDao {

	private Connection connection;

	public CadastrarDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarDespesa(CadastrarDespesa cadloc) {

		String sql = "SELECT * FROM despesa WHERE periodo = '" + CadastrarDespesa.tfperiodolocatario.getText()
				+ "'AND unidade = '" + CadastrarDespesa.cbcadnovadespesaunidade.getSelectedItem() + "' AND nome = '"
				+ CadastrarDespesa.cbnomedespesa.getSelectedItem() + "' AND valor = '"
				+ CadastrarDespesa.tfvalordespesa.getText() + "' AND empreendimento = '"
				+ CadastrarDespesa.cbcadnovadespesaempreendimento.getSelectedItem() + "' AND competencia = '"
				+ CadastrarDespesa.cbcompetenciadespesa.getSelectedItem() + "' AND datadespesa = '"
				+ CadastrarDespesa.tfdatadespesa.getText() + "'";
		
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

				JOptionPane.showMessageDialog(null, "REGISTRO DE DESPESA JÁ EXITE");
			}else{

		String sql1 = " INSERT INTO despesa (periodo,unidade,nome,valor,obs_despesa,empreendimento,competencia,datadespesa) VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql1);
			ps.setString(1, CadastrarDespesa.tfperiodolocatario.getText());
			ps.setString(2, CadastrarDespesa.cbcadnovadespesaunidade.getSelectedItem().toString());
			ps.setString(3, CadastrarDespesa.cbnomedespesa.getSelectedItem().toString());
			ps.setDouble(4, Double.parseDouble(CadastrarDespesa.tfvalordespesa.getText()));
			ps.setString(5, CadastrarDespesa.tfobsdespesa.getText());
			ps.setString(6, CadastrarDespesa.cbcadnovadespesaempreendimento.getSelectedItem().toString());
			ps.setString(7, CadastrarDespesa.cbcompetenciadespesa.getSelectedItem().toString());
			ps.setString(8, CadastrarDespesa.tfdatadespesa.getText());
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "NOVA DESPESA CADASTRADA COM SUCESSO");
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
