package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.view.AlterarDespesa;
import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.AlterarReceita;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.CadastrarReceita;
import br.com.controle.imobiliario.view.IncluirNovaDespesa;

public class AbrirTelaAlterarReceita {

	public void abretela() {

		AlterarReceita ar = new AlterarReceita();
		ar.setVisible(true);
		
		int ind = CadastrarReceita.tabelareceita.getSelectedRow();
		
		ar.tfidreceitaalterar.setText(CadastrarReceita.tabelareceita.getValueAt(ind, 0).toString());
		ar.cbnomereceitaalterar.setSelectedItem((CadastrarReceita.tabelareceita.getValueAt(ind, 1).toString()));
		ar.tfvalorreceita.setText(CadastrarReceita.tabelareceita.getValueAt(ind, 2).toString());
		ar.cbcompetenciareceita.setSelectedItem((CadastrarReceita.tabelareceita.getValueAt(ind, 2).toString()));
		ar.tfobsreceita.setText(CadastrarReceita.tabelareceita.getValueAt(ind, 4).toString());
	}
}
