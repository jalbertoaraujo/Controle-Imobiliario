package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.controler.IncluirDespesa;
import br.com.controle.imobiliario.controler.IncluirReceita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarImoveis;
import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.AlterarNovaReceita;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.principal;

public class AlterarTipoDespesaDao {

	private Connection connection;

	public AlterarTipoDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<IncluirDespesa> dados = new ArrayList<IncluirDespesa>();

		String sql = "UPDATE descdespesa SET descricao = '" + AlterarNovaDespesa.tfalterartipodespesa.getText()
				+ "' WHERE id_descdespesa = '" + AlterarNovaDespesa.tfidalterartipodespesa.getText() + "'";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse retorna Conexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "DESPESA ALTERADA COM SUCESSO");
			AlterarNovaDespesa.tfidalterartipodespesa.setText("");
			AlterarNovaDespesa.tfalterartipodespesa.setText("");			
			//throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
