package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.controler.Imoveis;
import br.com.controle.imobiliario.controler.SaldoAnual;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.InfAnualSaldo;
import br.com.controle.imobiliario.view.InfImovel;
import br.com.controle.imobiliario.view.principal;

public class ListaSaldoAnualDao {
	
	private Connection connection;
	
	public ListaSaldoAnualDao(){
		
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void listar() {
		
		List<SaldoAnual> dados = new ArrayList<SaldoAnual>();
		
		DefaultTableModel tab = (DefaultTableModel) EstatisticaImoveis.tabelasaldoanual.getModel();
		
		String sql = "SELECT * FROM saldoanual WHERE empreendimento = '" + EstatisticaImoveis.tfempreendimentoestatisticaimovel.getText() + "' AND unidade='"+EstatisticaImoveis.tfestatisticaunidade.getText()+"'";
		
		try {

			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();
			
			while (rs.next()) {
				
				SaldoAnual saldoanual = new SaldoAnual();
				
				saldoanual.setId_saldoanual(rs.getInt("id_saldoanual"));
				saldoanual.setEmpreendimento(rs.getString("empreendimento"));
				saldoanual.setUnidade(rs.getString("unidade"));
				saldoanual.setPeriodo(rs.getString("periodo"));
				saldoanual.setTotalreceita(rs.getString("totalreceita"));
				saldoanual.setTotaldespesa(rs.getString("totaldespesa"));
				saldoanual.setSaldo(rs.getString("saldo"));
				saldoanual.setCodigo(rs.getString("codigo"));
				
				dados.add(saldoanual);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}															
		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (SaldoAnual temp : dados) {
			Object[] linha = { temp.getPeriodo(), temp.getTotalreceita(), temp.getTotaldespesa(), temp.getSaldo() };
			tab.addRow(linha);
		}	}
}
