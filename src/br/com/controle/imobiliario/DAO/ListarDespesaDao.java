package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.controler.Receita;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ListarDespesaDao {

	private Connection connection;

	public ListarDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void Listar() {

		List<Despesa> dados = new ArrayList<Despesa>();

		DefaultTableModel tab = (DefaultTableModel) CadastrarDespesa.tabeladespesa.getModel();

		String sql = "SELECT * FROM despesa WHERE empreendimento = '"+CadastrarDespesa.cbcadnovadespesaempreendimento.getSelectedItem()+"' AND unidade = '" + CadastrarDespesa.cbcadnovadespesaunidade.getSelectedItem() + "'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Despesa despesa = new Despesa();

				despesa.setId_despesa(rs.getInt("id_despesa"));
				despesa.setPeriodo(rs.getString("periodo"));
				despesa.setUnidade(rs.getString("unidade"));
				despesa.setNome(rs.getString("nome"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setCompetencia(rs.getString("competencia"));
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
			Object[] linha = {temp.getId_despesa(), temp.getNome(), temp.getValor(), temp.getCompetencia(), temp.getObs_despesa()};
			tab.addRow(linha);			
			
		}
	}
}