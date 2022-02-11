package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.controler.Despesa;
import br.com.controle.imobiliario.controler.SaldoAnual;
import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.AlterarNovaReceita;
import br.com.controle.imobiliario.view.EstatisticaImoveis;


public class CadastrarSaldoAnualDao {

	private Connection connection;

	public CadastrarSaldoAnualDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarsaldoanual(EstatisticaImoveis estatisticaimoveis) {

		String sql = "SELECT * FROM saldoanual WHERE empreendimento = '"+ EstatisticaImoveis.tfempreendimentoestatisticaimovel.getText() +"' AND unidade = '"+ EstatisticaImoveis.tfestatisticaunidade.getText() +"' AND periodo = '"+ EstatisticaImoveis.cbinfinicialdespesa.getSelectedItem() +"'"; 
		
		try {			
			PreparedStatement prep = connection.prepareStatement(sql);// esse retornaConexao está tratando da conexão com o bd.
			ResultSet rs = prep.executeQuery();

			if(rs.next()) {			
			
			JOptionPane.showMessageDialog(null, "REGISTRO JÁ EXITE");	
			//String p1 = (rs.getString("id_saldoanual"));		
			List<SaldoAnual> dados = new ArrayList<SaldoAnual>();			
			String sql1 = "UPDATE saldoanual set saldo = '"+EstatisticaImoveis.tfinflucro.getText()+"' WHERE empreendimento = '"+EstatisticaImoveis.tfempreendimentoestatisticaimovel.getText()+"'";
			try {
				PreparedStatement ps = connection.prepareStatement(sql1);
			} catch (SQLException erro) {
				throw new RuntimeException(erro);
			}	
			JOptionPane.showMessageDialog(null, "SALDO ALTERADO");		
			}else{
				String sql3 = "INSERT INTO saldoanual (empreendimento,unidade,periodo,totalreceita,totaldespesa,saldo,codigo) VALUES (?,?,?,?,?,?,?)";

				try {
					PreparedStatement ps = connection.prepareStatement(sql3);
					ps.setString(1, EstatisticaImoveis.tfempreendimentoestatisticaimovel.getText());
					ps.setString(2, EstatisticaImoveis.tfestatisticaunidade.getText());
					ps.setString(3, EstatisticaImoveis.cbinfinicialdespesa.getSelectedItem().toString());
					ps.setString(4, EstatisticaImoveis.tftotalreceita.getText());
					ps.setString(5, EstatisticaImoveis.tftotaldespesa.getText());
					ps.setString(6, EstatisticaImoveis.tfinflucro.getText());
					ps.setString(7, EstatisticaImoveis.tfcodsaldoanual.getText());
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null, "SALDO ANUAL CADASTRADO COM SUCESSO");
				} catch (SQLException erro) {
					throw new RuntimeException(erro);
				}	
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
