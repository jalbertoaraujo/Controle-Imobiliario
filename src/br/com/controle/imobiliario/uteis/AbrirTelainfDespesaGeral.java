package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.view.InfDespesaGeral;
import br.com.controle.imobiliario.view.InfImovel;
import br.com.controle.imobiliario.view.InfReceitaGeral;

public class AbrirTelainfDespesaGeral {

	public void AbrirTelainfDespesaGeral(){
		
		InfDespesaGeral idg = new InfDespesaGeral();
		idg.setVisible(true);
		
		int ind = InfImovel.tabelainfimoveis.getSelectedRow();
		
		idg.tfempreendimentodespesageral.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 1).toString());
		idg.tfunidadedespesageral.setText(InfImovel.tabelainfimoveis.getValueAt(ind, 2).toString());
	}
}
