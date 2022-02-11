package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.controler.IncluirDespesa;
import br.com.controle.imobiliario.controler.SaldoAnual;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarDespesa;
import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.InfAnualSaldo;

public class AlterarSaldoPeriodoDao {

	private Connection connection;

	public AlterarSaldoPeriodoDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public void listar() {

		List<SaldoAnual> dados = new ArrayList<SaldoAnual>();

		String sql = "SELECT * FROM saldoanual ";
		try {
			PreparedStatement prep = connection.prepareStatement(sql);// esse retorna Conexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

		} catch (SQLException e) {		
			// throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
