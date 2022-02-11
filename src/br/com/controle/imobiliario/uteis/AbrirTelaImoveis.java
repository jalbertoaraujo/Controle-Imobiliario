package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.view.AlterarImoveis;
import br.com.controle.imobiliario.view.principal;

public class AbrirTelaImoveis {
	
	public void AbrirTelaImoveis(){
		
		AlterarImoveis ai = new AlterarImoveis();
		ai.setVisible(true);
		
		int ind = principal.table.getSelectedRow();
		
		ai.tfcodalterar.setText(principal.table.getValueAt(ind, 0).toString());
		
	}

}
