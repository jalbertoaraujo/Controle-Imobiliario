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
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDespesaDao {

	private Connection connection;

	public RelatorioDespesaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void RelatorioDespesaEmpreendimento() {

		List<Despesa> dados = new ArrayList<Despesa>();		

		String sql = "SELECT * FROM despesa where empreendimento = '"+RelatorioDespesaporEmpreendimento.cbrelatdespesaempreendimento.getSelectedItem()+"' and unidade = '"+RelatorioDespesaporEmpreendimento.cbrelatdespesaunidade.getSelectedItem()+"'";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();
			
			JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
			JasperPrint jp = JasperFillManager.fillReport("Ireport/despesa.jasper", new HashMap(), jrrs);
			JasperViewer.viewReport(jp,false);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}