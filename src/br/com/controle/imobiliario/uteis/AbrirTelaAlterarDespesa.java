package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.view.AlterarDespesa;
import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.CadastrarDespesa;
import br.com.controle.imobiliario.view.IncluirNovaDespesa;

public class AbrirTelaAlterarDespesa {

	public void abretela() {

		AlterarDespesa ad = new AlterarDespesa();
		ad.setVisible(true);
		
		int ind = CadastrarDespesa.tabeladespesa.getSelectedRow();
		
		ad.tfiddespesaalterar.setText(CadastrarDespesa.tabeladespesa.getValueAt(ind, 0).toString());
		ad.cbnomedespesaalterar.setSelectedItem((CadastrarDespesa.tabeladespesa.getValueAt(ind, 1).toString()));
		ad.tfvalordespesa.setText(CadastrarDespesa.tabeladespesa.getValueAt(ind, 2).toString());
		ad.cbcompetenciadespesa.setSelectedItem((CadastrarDespesa.tabeladespesa.getValueAt(ind, 3).toString()));
		ad.tfobsdespesa.setText(CadastrarDespesa.tabeladespesa.getValueAt(ind, 4).toString());
	}
}
