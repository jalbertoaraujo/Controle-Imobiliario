package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.CadastrarReceita;

public class CadastrarReceitaDao {

	private Connection connection;

	public CadastrarReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarReceita(CadastrarReceita cadaloc) {

		String sql = "SELECT * FROM receita WHERE periodo = '" + CadastrarReceita.tfperiodolocatario.getText()
				+ "'AND unidade = '" + CadastrarReceita.cbcadnovareceita.getSelectedItem() + "' AND nome = '"
				+ CadastrarReceita.cbnomereceita.getSelectedItem() + "' AND valor = '"
				+ CadastrarReceita.tfvalorreceita.getText() + "' AND empreendimento = '"
				+ CadastrarReceita.cbcadnovareceitaempreendimento.getSelectedItem() + "' AND competencia = '"
				+ CadastrarReceita.cbcompetenciareceita.getSelectedItem() + "' AND datareceita = '"
				+ CadastrarReceita.tfdatareceita.getText() + "'";
		
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

				JOptionPane.showMessageDialog(null, "REGISTRO DE RECEITA JÁ EXITE");
			}else{

		
		String sql1 = " INSERT INTO receita (periodo,unidade,nome,valor,obs_receita,empreendimento,competencia,datareceita) VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql1);
			ps.setString(1, CadastrarReceita.tfperiodolocatario.getText());
			ps.setString(2, CadastrarReceita.cbcadnovareceita.getSelectedItem().toString());
			ps.setString(3, CadastrarReceita.cbnomereceita.getSelectedItem().toString());
			ps.setDouble(4, Double.parseDouble(CadastrarReceita.tfvalorreceita.getText()));
			ps.setString(5, CadastrarReceita.tfobsreceita.getText());			
			ps.setString(6, CadastrarReceita.cbcadnovareceitaempreendimento.getSelectedItem().toString());
			ps.setString(7, CadastrarReceita.cbcompetenciareceita.getSelectedItem().toString());
			ps.setString(8, CadastrarReceita.tfdatareceita.getText());
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "NOVA RECEITA CADASTRADA COM SUCESSO");
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