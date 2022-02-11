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
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.IncluirNovaDespesa;


public class ListarIncluirDespesaDao {
	
	private Connection connection;

	public ListarIncluirDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<IncluirDespesa> dados = new ArrayList<IncluirDespesa>();

		DefaultTableModel tab = (DefaultTableModel) IncluirNovaDespesa.table.getModel();

		String sql = "SELECT * FROM descdespesa ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				IncluirDespesa incluirdespesa = new IncluirDespesa(null, sql);

				incluirdespesa.setId_descdespesa(rs.getInt("id_descdespesa"));
				incluirdespesa.setDescricao(rs.getString("descricao"));
				

				dados.add(incluirdespesa);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (IncluirDespesa temp : dados) {
			Object[] linha = { temp.getId_descdespesa(), temp.getDescricao() };
			tab.addRow(linha);

		}
	}

}
