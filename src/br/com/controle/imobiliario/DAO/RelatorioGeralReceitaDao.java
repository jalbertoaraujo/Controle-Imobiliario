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

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.Login;
import br.com.controle.imobiliario.view.principal;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioGeralReceitaDao {

	private Connection connection;

	public RelatorioGeralReceitaDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void relatoriogeralreceita() {

		List<Imoveis> dados = new ArrayList<Imoveis>();

		String sql = "SELECT * FROM receita order by unidade asc";

		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();
			
			JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
			JasperPrint jp = JasperFillManager.fillReport("Ireport/ReceitaGeral.jasper", new HashMap(), jrrs);
			JasperViewer.viewReport(jp,false);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO AO GERAR RELATÓRIO");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
