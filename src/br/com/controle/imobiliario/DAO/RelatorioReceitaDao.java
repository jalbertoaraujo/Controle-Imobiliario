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
import br.com.controle.imobiliario.view.RelatorioDespesaporEmpreendimento;
import br.com.controle.imobiliario.view.RelatorioReceitaporEmpreendimento;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioReceitaDao {

	private Connection connection;

	public RelatorioReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void RelatorioReceitaEmpreendimento() {

		List<Despesa> dados = new ArrayList<Despesa>();		

		String sql = "SELECT * FROM receita where empreendimento = '"+RelatorioReceitaporEmpreendimento.cbrelatreceitaempreendimento.getSelectedItem()+"' and unidade = '"+RelatorioReceitaporEmpreendimento.cbrelatreceitaunidade.getSelectedItem()+"'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao est? tratando da conex?o com o bd.
			ResultSet rs = prep.executeQuery();
			
			JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
			JasperPrint jp = JasperFillManager.fillReport("Ireport/receita.jasper", new HashMap(), jrrs);
			JasperViewer.viewReport(jp,false);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}