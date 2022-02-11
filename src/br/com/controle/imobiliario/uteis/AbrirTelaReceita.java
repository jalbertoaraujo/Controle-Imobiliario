package br.com.controle.imobiliario.uteis;


import br.com.controle.imobiliario.view.AlterarNovaReceita;
import br.com.controle.imobiliario.view.IncluirNovaReceita;

public class AbrirTelaReceita {

	public void abretela() {

		AlterarNovaReceita anr = new AlterarNovaReceita();
		anr.setVisible(true);
		
		int ind = IncluirNovaReceita.table.getSelectedRow();
		
		anr.tfidalterartiporeceita.setText(IncluirNovaReceita.table.getValueAt(ind, 0).toString());
		anr.tfalterartiporeceita.setText(IncluirNovaReceita.table.getValueAt(ind, 1).toString());
	}
}
