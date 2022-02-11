package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.controler.IncluirDespesa;
import br.com.controle.imobiliario.controler.IncluirReceita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarNovaReceita;
import br.com.controle.imobiliario.view.IncluirNovaDespesa;
import br.com.controle.imobiliario.view.IncluirNovaReceita;


public class ListarIncluirReceitaDao {
	
	private Connection connection;

	public ListarIncluirReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<IncluirReceita> dados = new ArrayList<IncluirReceita>();

		DefaultTableModel tab = (DefaultTableModel) IncluirNovaReceita.table.getModel();
		

		String sql = "SELECT * FROM descreceita ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				IncluirReceita incluirreceita = new IncluirReceita(null, sql);

				incluirreceita.setId_descreceita(rs.getInt("id_descreceita"));
				incluirreceita.setDescricao(rs.getString("descricao"));
				

				dados.add(incluirreceita);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (IncluirReceita temp : dados) {
			Object[] linha = { temp.getId_descreceita(), temp.getDescricao() };
			tab.addRow(linha);

		}
	}

}
