package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarReceita;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.Estatisticas;

public class ListarInfReceitaDao {
	
	private Connection connection;

	public ListarInfReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Receita> dados = new ArrayList<Receita>();

		DefaultTableModel tab = (DefaultTableModel) EstatisticaImoveis.tabelaestatisticareceitaimovel.getModel();

		String sql = "SELECT * FROM receita WHERE empreendimento = '"+EstatisticaImoveis.tfempreendimentoestatisticaimovel.getText()+"' AND unidade = '" + EstatisticaImoveis.tfestatisticaunidade.getText() + "' AND periodo = '"+ EstatisticaImoveis.cbinfinicialdespesa.getSelectedItem()+"' ORDER BY id_receita ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
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
			Object[] linha = { temp.getNome(), temp.getValor() };
			tab.addRow(linha);

		}
	}

}
