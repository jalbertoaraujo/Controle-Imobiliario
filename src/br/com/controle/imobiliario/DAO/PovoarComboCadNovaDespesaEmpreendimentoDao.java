package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.CadastrarReceita;
import br.com.controle.imobiliario.view.Estatisticas;

public class PovoarComboCadNovaDespesaEmpreendimentoDao {
	
	private Connection connection;

	public PovoarComboCadNovaDespesaEmpreendimentoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<Imoveis> dados = new ArrayList<Imoveis>();

		String sql = "SELECT DISTINCT empreendimento FROM imoveis order by empreendimento asc ";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				CadastrarDespesa.cbcadnovadespesaempreendimento.addItem(rs.getString("empreendimento"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
