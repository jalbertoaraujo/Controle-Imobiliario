package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.DAO.ListarInfReceitaGeralDao;
import br.com.controle.imobiliario.DAO.SomaInfReceitaDao;
import br.com.controle.imobiliario.view.InfImovel;
import br.com.controle.imobiliario.view.InfReceitaGeral;

public class AbrirTelainfReceitaGeral {

	public void AbrirTelainfReceitaGeral(){
		
		InfReceitaGeral irg = new InfReceitaGeral();
		irg.setVisible(true);
		
		int ind = InfImovel.tabelainfimoveis.getSelectedRow();
		
		irg.tfempreendimentoreceitageral.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 1).toString());
		irg.tfunidadereceitageral.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 2).toString());	
	
	}
}
