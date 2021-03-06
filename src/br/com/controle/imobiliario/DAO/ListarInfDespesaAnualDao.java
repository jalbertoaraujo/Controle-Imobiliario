package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Despesa;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.InfImoveisDespesaGeralImovel;

public class ListarInfDespesaAnualDao {
	
	private Connection connection;

	public ListarInfDespesaAnualDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Despesa> dados = new ArrayList<Despesa>();

		DefaultTableModel tab = (DefaultTableModel) InfImoveisDespesaGeralImovel.tabelasaldodespesaanual.getModel();

		String sql = "SELECT * FROM despesa WHERE empreendimento = '"+InfImoveisDespesaGeralImovel.cbcadnovadespesaempreendimentoperiodo.getSelectedItem()+"' AND unidade = '" + InfImoveisDespesaGeralImovel.cbcadnovadespesaperiodo.getSelectedItem() + "' ORDER BY id_despesa ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Despesa despesa = new Despesa();

				despesa.setId_despesa(rs.getInt("id_despesa"));
				despesa.setPeriodo(rs.getString("periodo"));
				despesa.setUnidade(rs.getString("unidade"));
				despesa.setNome(rs.getString("nome"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setObs_despesa(rs.getString("obs_despesa"));

				dados.add(despesa);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (Despesa temp : dados) {
			Object[] linha = { temp.getNome(), temp.getValor(), temp.getPeriodo() };
			tab.addRow(linha);

		}
	}

}
