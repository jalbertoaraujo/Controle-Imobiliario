package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.Estatisticas;
import br.com.controle.imobiliario.view.InfImoveisDespesaGeralImovel;
import br.com.controle.imobiliario.view.InfImoveisReceitaGeralImovel;
import br.com.controle.imobiliario.view.InfReceitaGeral;

public class ListarInfReceitaGeralDao {
	
	private Connection connection;

	public ListarInfReceitaGeralDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Receita> dados = new ArrayList<Receita>();

		DefaultTableModel tab = (DefaultTableModel) InfReceitaGeral.tabelasaldoanual.getModel();

		String sql = "SELECT * FROM receita WHERE empreendimento = '"+InfReceitaGeral.tfempreendimentoreceitageral.getText()+"' AND unidade = '"+InfReceitaGeral.tfunidadereceitageral.getText()+"'ORDER BY empreendimento ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est� tratando da conex�o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Receita receita = new Receita();

				receita.setId_receita(rs.getInt("id_receita"));
				receita.setPeriodo(rs.getString("periodo"));
				receita.setUnidade(rs.getString("unidade"));
				receita.setNome(rs.getString("nome"));
				receita.setValor(rs.getDouble("valor"));
				receita.setObs_receita(rs.getString("obs_receita"));

				dados.add(receita);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (Receita temp : dados) {
			Object[] linha = { temp.getNome(), temp.getValor(), temp.getPeriodo() };
			tab.addRow(linha);

		}
	}

}
