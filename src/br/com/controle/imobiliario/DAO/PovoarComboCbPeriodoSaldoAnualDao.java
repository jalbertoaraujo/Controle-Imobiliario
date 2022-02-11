package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.controler.SaldoAnual;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.InfAnualSaldo;

public class PovoarComboCbPeriodoSaldoAnualDao {
	
	private Connection connection;

	public PovoarComboCbPeriodoSaldoAnualDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void listar() {

		List<SaldoAnual> dados = new ArrayList<SaldoAnual>();
		
		String sql = "SELECT DISTINCT periodo FROM saldoanual ORDER BY periodo ASC";
		
		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				
				InfAnualSaldo.cbperiodosaldoanual.addItem(rs.getString("periodo"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	

