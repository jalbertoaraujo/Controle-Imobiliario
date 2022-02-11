package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.DAO.ListaSaldoAnualDao;
import br.com.controle.imobiliario.DAO.ListarInfDespesaDao;
import br.com.controle.imobiliario.DAO.ListarInfReceitaDao;
import br.com.controle.imobiliario.DAO.SomaInfDespesaIntervaloDao;
import br.com.controle.imobiliario.DAO.SomaInfReceitaIntervaloDao;
import br.com.controle.imobiliario.DAO.ValorTotalImoveisDao;
import br.com.controle.imobiliario.view.EstatisticaImoveis;
import br.com.controle.imobiliario.view.InfImovel;

public class AbrirTelaEstatisticaImoveis {
	
	public void AbrirTelaEstatisticaImoveis(){			
		
		EstatisticaImoveis ei = new EstatisticaImoveis();
		ei.setVisible(true);
		
		int ind = InfImovel.tabelainfimoveis.getSelectedRow();
		
		ei.tfcodsaldoanual.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 0).toString());
		ei.tfempreendimentoestatisticaimovel.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 1).toString());
		ei.tfestatisticaunidade.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 2).toString());
//		ei.tfinfvalorimovel.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 5).toString());
		
		ListarInfReceitaDao lird = new ListarInfReceitaDao();
		lird.Listar();
		ListarInfDespesaDao lid = new ListarInfDespesaDao();
		lid.Listar();
		SomaInfDespesaIntervaloDao sidi = new SomaInfDespesaIntervaloDao();
		sidi.Listar();
		SomaInfReceitaIntervaloDao siri = new SomaInfReceitaIntervaloDao();
		siri.Listar();
		
		EstatisticaImoveis.tfinflucro.setText("");
		SomaInfReceitaIntervaloDao siri1 = new SomaInfReceitaIntervaloDao();
		siri1.Listar();
		SomaInfDespesaIntervaloDao sidi1 = new SomaInfDespesaIntervaloDao();
		sidi1.Listar();	
		ValorTotalImoveisDao vti = new ValorTotalImoveisDao();
		vti.listar();

		Double valor2 = 0.0;

		if (EstatisticaImoveis.tftotalreceita.getText().equals("")) {
			EstatisticaImoveis.tftotalreceita.setText(String.valueOf(valor2));
		}if(EstatisticaImoveis.tftotaldespesa.getText().equals("")){
			EstatisticaImoveis.tftotaldespesa.setText(String.valueOf(valor2));
		}
		Double receita = Double.parseDouble(EstatisticaImoveis.tftotalreceita.getText());
		Double despesa = Double.parseDouble(EstatisticaImoveis.tftotaldespesa.getText());
		Double valor = receita - despesa;
		EstatisticaImoveis.tfinflucro.setText(String.valueOf(valor));
		Double esp1 = Double.parseDouble(EstatisticaImoveis.tfinfvalorimovel.getText());
		Double esp2 = esp1*0.005;
		Double saldoesperado = esp2;
		EstatisticaImoveis.tfinfsaldominimoesperado.setText(String.valueOf(saldoesperado));
		Double val1 = Double.parseDouble(EstatisticaImoveis.tfinflucro.getText());
		Double val2 = Double.parseDouble(EstatisticaImoveis.tfinfsaldominimoesperado.getText());
		if(val1 > val2){
			EstatisticaImoveis.lblimagempositivo.setVisible(true);
			EstatisticaImoveis.lblImvelObteveLucro.setVisible(true);
			//JOptionPane.showMessageDialog(null, "IMÓVEL OBTEVE LUCRO NESTE MÊS");
			//lblimagempositivo.setVisible(false);
		}else{
			EstatisticaImoveis.lblimagemnegativo.setVisible(true);
			EstatisticaImoveis.lblImvelNaoObteveLucro.setVisible(true);
			//JOptionPane.showMessageDialog(null, "IMÓVEL NÃO OBTEVE LUCRO NESTE MÊS");
			//lblimagemnegativo.setVisible(false);
		}		
		
	}

}
